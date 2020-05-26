package retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceWeather {

    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("APPID") app_id: String
    ): Call<ResponseWeather>

    @GET("data/2.5/weather?")
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("APPID") app_id: String
    ): ResponseWeather

}