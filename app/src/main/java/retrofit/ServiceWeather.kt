package retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val APP_ID = "2e65127e909e178d0af311a81f39948c"

interface ServiceWeather {

    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("APPID") app_id: String = APP_ID
    ): Call<ResponseWeather>

    @GET("data/2.5/weather?")
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("APPID") app_id: String = APP_ID
    ): ResponseWeather

}