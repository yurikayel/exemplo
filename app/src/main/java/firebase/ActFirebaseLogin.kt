package firebase

import android.content.Intent
import android.os.Bundle
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActFirebaseLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN
import custom.onClick
import custom.setImageFromURL
import custom.toast
import custom.viewModel

private const val DEFAULT_PIC = "https://i.ibb.co/LxQbYGz/cher.jpg"

class ActFirebaseLogin : ActBind<ActFirebaseLoginBinding>() {

    override val binding: ActFirebaseLoginBinding by viewBind()

    private val viewModel: ViewModelFirebaseLogin by viewModel()
    private val user get() = viewModel.user

    private val loginCode = 300
    private val loginIntent by lazy {
        GoogleSignIn.getClient( // um objeto aí pra fazer uns login
            this@ActFirebaseLogin, GoogleSignInOptions.Builder(DEFAULT_GAMES_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        ).signInIntent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.notifyUI = { message ->
            updateUI(message)
        }
    }

    override fun onResume() {
        super.onResume()
        updateUI("onResume")
    }

    override fun ActFirebaseLoginBinding.onBoundView() {
        fireLogIn.onClick { startActivityForResult(loginIntent, loginCode) }
        fireLogOff.onClick(viewModel::logOff)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            loginCode -> viewModel.logIn(data)
            0         -> {
            }
            1         -> {
            }
        }
    }

    private fun updateUI(message: String) {
        toast(message)
        binding.run {
            fireLoginName.text = user?.displayName ?: "NOME"
            fireLoginEmail.text = user?.email ?: "EMAIL"
            fireLoginPic.setImageFromURL(user?.photoUrl ?: DEFAULT_PIC)
        }
    }
}