package retrofit

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private var url = "https://api.openweathermap.org/"
private var service = ServiceWeather::class

class ViewModelCorotina : ViewModel() {

    val weather = MutableLiveData<ResponseWeather>()
    val stringFormatada = MutableLiveData<String>()

    private val weatherService = RetroInit(url).create(service)

    fun getWeather(lat: String, lon: String, AppId: String) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                weatherService.getCurrentWeather(lat, lon, AppId).let {
                    weather.postValue(it)
                    stringFormatada.postValue(
                        "Country: " + it.sys?.country + "\n" +
                        "Temperature: " + it.main?.temp + "\n" +
                        "Temperature(Min): " + it.main?.temp_min + "\n" +
                        "Temperature(Max): " + it.main?.temp_max + "\n" +
                        "Humidity: " + it.main?.humidity + "\n" +
                        "Pressure: " + it.main?.pressure
                    )
                }
            }
        }
    }
}
