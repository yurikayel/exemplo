package firebase

import android.content.Intent
import android.os.Bundle
import base.ActBind
import com.example.exemplo.databinding.ActFirebaseLoginBinding
import custom.onClick
import custom.setImageFromURL
import custom.viewModel

private const val DEFAULT_PIC = "https://i.ibb.co/LxQbYGz/cher.jpg"

class ActFirebaseLogin : ActBind<ActFirebaseLoginBinding>() {

    override val binding: ActFirebaseLoginBinding by viewBind()
    private val viewModel: ViewModelFirebaseLogin by viewModel()
    private val user get() = viewModel.user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.activity = this
        viewModel.notifyUI = { updateUI() }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    override fun ActFirebaseLoginBinding.onBoundView() {
        fireLogIn.onClick(viewModel::callLogin)
        fireLogOff.onClick(viewModel::logOff)
        updateUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            viewModel.loginRequestCode -> viewModel.logIn(data)
        }
    }

    private fun updateUI() {
        binding.run {
            fireLoginName.text = user?.displayName ?: "NOME"
            fireLoginEmail.text = user?.email ?: "EMAIL"
            fireLoginPic.setImageFromURL(user?.photoUrl ?: DEFAULT_PIC)
        }
    }

}