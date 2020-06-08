package firebase

import android.content.Intent
import android.os.Bundle
import base.ActBind
import com.example.exemplo.databinding.ActFirebaseLoginBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.activity = this
        viewModel.notifyUI = { updateUI(it) }
    }

    override fun onResume() {
        super.onResume()
        updateUI("onResume")
    }

    override fun ActFirebaseLoginBinding.onBoundView() {
        fireLogIn.onClick { startActivityForResult(viewModel.client.signInIntent, loginCode) }
        fireLogOff.onClick(viewModel::logOff)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            loginCode -> viewModel.logIn(data)
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