package retrofit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActRetrofitBinding
import custom.string
import custom.viewBind

class ActCorotina : ActBind<ActRetrofitBinding>() {

    override val binding: ActRetrofitBinding by viewBind()
    private val viewModel: ViewModelCorotina by viewModels()

    override fun Bundle.onExtras() {
        getString("chaves", "henrique")
        getString("kiko", "rafinha")
        getString("trickjaum", "joao")
    }

    override fun ActRetrofitBinding.onBoundView() {
        retroButton.text = getString(R.string.consultar_tempo)

        retroButton.setOnClickListener {
            viewModel.getWeather(
                retroLatitude.string,
                retroLongitude.string
            )
        }

        viewModel.stringFormatada.observe(this@ActCorotina, Observer { retroText.text = it })
    }
}

