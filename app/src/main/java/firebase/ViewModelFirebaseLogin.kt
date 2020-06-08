package firebase

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.exemplo.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider.getCredential

class ViewModelFirebaseLogin : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val user: FirebaseUser? get() = auth.currentUser
    lateinit var activity: Activity

    val client: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(
            activity, GoogleSignInOptions.Builder(DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )
    }

    lateinit var notifyUI: (String) -> Unit

    fun logIn(data: Intent?) = try {
        GoogleSignIn.getSignedInAccountFromIntent(data).run {
            auth.signInWithCredential(getCredential(result?.idToken, null))
                .addOnCompleteListener { if (isSuccessful) onLoginSuccess() else onLoginFail() }
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
        } else message = "Já tá deslogado ow!"
        notifyUI(message)
    }

    val onLoginSuccess = { notifyUI("${user?.displayName} logou com sucesso!") }

    val onLoginFail = { notifyUI("Falha ao tentar login") }
}