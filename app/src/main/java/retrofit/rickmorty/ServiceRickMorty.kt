package retrofit.rickmorty

import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceRickMorty {

    @GET("character/?")
    suspend fun getCharacters(
        @Query("page") page: Int = 1
    ): CharacterResponse
}