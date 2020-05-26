package retrofit

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ViewModelCorotina : ViewModel() {

    val stringFormatada = MutableLiveData<String>()
    private val weatherRepo = RepositoryWeather()

    fun getWeather(lat: String, lon: String) = CoroutineScope(IO).launch {
        weatherRepo.getWeather(lat, lon).let {
            stringFormatada.postValue(
                "País: " + it.sys?.country + "\n" +
                "Temp: " + it.main?.temp + "\n" +
                "Temp(Min): " + it.main?.temp_min + "\n" +
                "Temp(Max): " + it.main?.temp_max + "\n" +
                "Humildade: " + it.main?.humidity + "\n" +
                "Pressão: " + it.main?.pressure
            )
        }
    }
}
