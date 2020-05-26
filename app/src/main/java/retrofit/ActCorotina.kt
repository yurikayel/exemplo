package retrofit

import android.arch.lifecycle.Observer
import base.ActBind
import com.example.exemplo.databinding.ActRandomBinding
import custom.viewModel

private const val APP_ID = "2e65127e909e178d0af311a81f39948c"
private var lat = "35"
private var lon = "139"

class ActCorotina : ActBind<ActRandomBinding>() {

    override val binding by lazy { bind(ActRandomBinding::class) }
    private val viewModel by lazy { viewModel<ViewModelCorotina>() }

    override fun ActRandomBinding.onBoundView() {
        randomButton.text = "Consultar o Tempo"

        randomButton.setOnClickListener { viewModel.getWeather(lat, lon, APP_ID) }
        viewModel.stringFormatada.observe(activity, Observer {
            randomText.text = it
        })
    }
}

