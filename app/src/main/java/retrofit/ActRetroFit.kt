package retrofit

import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActRetrofitBinding
import custom.string
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActRetroFit : ActBind<ActRetrofitBinding>(), Callback<ResponseWeather> {

    override val binding by lazy { bind(ActRetrofitBinding::class) }
    private val weatherService =
        RetroInit("https://api.openweathermap.org/").create(ServiceWeather::class)

    override fun ActRetrofitBinding.onBoundView() {
        retroButton.text = getString(R.string.consultar_tempo)
        retroButton.setOnClickListener {
            getWeather(
                retroLatitude.string,
                retroLongitude.string
            )
        }
    }

    private fun getWeather(lat: String, lon: String) =
        weatherService.getCurrentWeatherData(lat, lon).enqueue(this@ActRetroFit)

    override fun onResponse(call: Call<ResponseWeather>, response: Response<ResponseWeather>) {
        binding.retroText.text = if (response.code() == 200) {
            response.body()?.run {
                "País: " + sys?.country + "\n" +
                "Temp: " + main?.temp + "\n" +
                "Temp(Min): " + main?.temp_min + "\n" +
                "Temp(Max): " + main?.temp_max + "\n" +
                "Humildade: " + main?.humidity + "\n" +
                "Pressão: " + main?.pressure
            }
        } else {
            "Erro de Back End"
        }
    }

    override fun onFailure(call: Call<ResponseWeather>, throwable: Throwable) {
        binding.retroText.text = throwable.message
    }
}
