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
import custom.toast

class ViewModelFirebaseLogin : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val user: FirebaseUser? get() = auth.currentUser
    val loginRequestCode = 300

    lateinit var activity: Activity

    private val client: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(
            activity, GoogleSignInOptions.Builder(DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )
    }

    lateinit var notifyUI: () -> Unit

    fun callLogin() {
        activity.startActivityForResult(client.signInIntent, loginRequestCode)
    }

    fun logIn(data: Intent?) = try {
        GoogleSignIn.getSignedInAccountFromIntent(data).run {
            auth.signInWithCredential(getCredential(result?.idToken, null))
                .addOnCompleteListener { if (isSuccessful) onLoginSuccess() else onLoginFail() }
        }
    } catch (exception: Exception) {
        onLoginFail()
        activity.toast(exception.message ?: "Falha ao tentar acessar conta Google")
    }

    fun logOff() {
        auth.signOut()
        notifyUI()
    }

    val onLoginSuccess = { notifyUI() }

    val onLoginFail = {
        activity.toast("Falha ao tentar login")
        notifyUI()
    }

}
