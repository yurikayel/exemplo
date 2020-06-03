package functions

import android.view.View
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActLambdaBinding
import custom.newButton
import custom.onClick
import custom.toast

class ActLambda : ActBind<ActLambdaBinding>() {

    override val binding by lazy { bind(ActLambdaBinding::class) }

    private val onClickListener = View.OnClickListener { toast("lambida") }
    private val button by lazy { newButton(R.style.Button) }

    override fun ActLambdaBinding.onBoundView() {
        lambdaButton.setOnClickListener(onClickListener)
        lambdaLinear.addView(button, 2)

        button.onClick {
            text = context.getString(R.string.trickjaum)
            toast("button")
        }

        (1..999).forEach {
            val button = newButton(R.style.Button)
            val text = it.toString()
            button.text = text
            button.onClick { toast(text) }
            lambdaLinear.addView(button)
        }
    }
}

