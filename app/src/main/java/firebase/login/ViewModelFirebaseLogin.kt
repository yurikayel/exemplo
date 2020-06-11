package firebase.login

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider.getCredential

class ViewModelFirebaseLogin : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Valguete
    val user get() = auth.currentUser

    lateinit var notifyUI: (String) -> Unit // observem que não tem atribuição aqui

    fun logIn(data: Intent?) = try {
        GoogleSignIn.getSignedInAccountFromIntent(data).run {
            val credential = getCredential(result?.idToken, null)
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) onLoginSuccess() else onLoginFail()
                }
        }
    } catch (exception: Exception) {
        onLoginFail()
        notifyUI(exception.message ?: "Falha ao tentar acessar conta Google")
    }

    fun logOff() {
        val message: String
        if (user != null) {
            message = "${user?.displayName} saiu!"
            auth.signOut()
        } else {
            message = "Já tá deslogado ow!"
        }
        notifyUI(message)
    }

    val onLoginSuccess = { notifyUI("${user?.displayName} logou com sucesso!") }

    val onLoginFail = { notifyUI("Falha ao tentar login") }
}