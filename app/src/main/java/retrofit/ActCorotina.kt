package retrofit

import android.arch.lifecycle.Observer
import base.ActBind
import com.example.exemplo.databinding.ActRetrofitBinding
import custom.string
import custom.viewModel

private const val APP_ID = "2e65127e909e178d0af311a81f39948c"

class ActCorotina : ActBind<ActRetrofitBinding>() {

    override val binding by lazy { bind(ActRetrofitBinding::class) }
    private val viewModel by lazy { viewModel<ViewModelCorotina>() }

    override fun ActRetrofitBinding.onBoundView() {
        retroButton.text = "Consultar o Tempo"

        retroButton.setOnClickListener {
            viewModel.getWeather(
                retroLatitude.string,
                retroLongitude.string,
                APP_ID
            )
        }
        viewModel.stringFormatada.observe(activity, Observer { retroText.text = it })
    }
}

