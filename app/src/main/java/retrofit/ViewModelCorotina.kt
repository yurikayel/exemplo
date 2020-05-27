package retrofit

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ViewModelCorotina : ViewModel() {

    val stringFormatada = MutableLiveData<String>()
    private val repoWeather = RepositoryWeather()

    fun getWeather(lat: String, lon: String) = CoroutineScope(IO).launch {
        repoWeather.getWeather(lat, lon).let { resposta ->
            stringFormatada.postValue(
                "País: " + resposta.sys?.country + "\n" +
                "Temp: " + resposta.main?.temp + "\n" +
                "Temp(Min): " + resposta.main?.temp_min + "\n" +
                "Temp(Max): " + resposta.main?.temp_max + "\n" +
                "Humildade: " + resposta.main?.humidity + "\n" +
                "Pressão: " + resposta.main?.pressure
            )
        }
    }
}
