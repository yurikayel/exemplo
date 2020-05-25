package retrofit

import base.ActBind
import com.example.exemplo.databinding.ActRandomBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private var AppId = "2e65127e909e178d0af311a81f39948c"
private var lat = "35"
private var lon = "139"
private var url = "https://api.openweathermap.org/"
private var service = WeatherService::class

class ActRetroFit : ActBind<ActRandomBinding>(), Callback<WeatherResponse> {

    override val binding by lazy { bind(ActRandomBinding::class) }
    private val weatherService = RetroInit(url).create(service)

    override fun ActRandomBinding.onBoundView() {
        randomButton.text = "Consultar o Tempo"
        randomButton.setOnClickListener { getWeather(lat, lon, AppId) }
    }

    private fun getWeather(lat: String, lon: String, AppId: String) =
        weatherService.getCurrentWeatherData(lat, lon, AppId).enqueue(this@ActRetroFit)

    override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
        binding.randomText.text = if (response.code() == 200) response.body()?.run {
            "Country: " + sys?.country + "\n" +
            "Temperature: " + main?.temp + "\n" +
            "Temperature(Min): " + main?.temp_min + "\n" +
            "Temperature(Max): " + main?.temp_max + "\n" +
            "Humidity: " + main?.humidity + "\n" +
            "Pressure: " + main?.pressure
        } else "Erro de Back End"
    }

    override fun onFailure(call: Call<WeatherResponse>, throwable: Throwable) {
        binding.randomText.text = throwable.message
    }
}
