package retrofit

import android.arch.lifecycle.Observer
import base.ActBind
import com.example.exemplo.databinding.ActRetrofitBinding
import custom.string
import custom.viewModel

class ActCorotina : ActBind<ActRetrofitBinding>() {

    override val binding by lazy { bind(ActRetrofitBinding::class) }
    private val viewModel by lazy { viewModel<ViewModelCorotina>() }

    override fun ActRetrofitBinding.onBoundView() {
        retroButton.text = "Consultar o Tempo"

        retroButton.setOnClickListener {
            viewModel.getWeather(
                retroLatitude.string,
                retroLongitude.string
            )
        }

        viewModel.stringFormatada.observe(activity, Observer { retroText.text = it })
    }
}

