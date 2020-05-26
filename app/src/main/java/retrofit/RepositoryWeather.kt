package retrofit

class RepositoryWeather {

    private var url = "https://api.openweathermap.org/"
    private var service = ServiceWeather::class

    private val weatherService = RetroInit(url).create(service)

    suspend fun getWeather(lat: String, lon: String): ResponseWeather {
        return weatherService.getCurrentWeather(lat, lon)
    }
}
