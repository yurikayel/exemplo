package retrofit.rickmorty

import retrofit.RetroInit

class RepositoryRickMorty {
    private var url = "https://rickandmortyapi.com/api/"
    private var service = ServiceRickMorty::class

    private val serviceRick = RetroInit(url).create(service)

    suspend fun getCharacters(page: Int = 1): CharacterResponse {
        return serviceRick.getCharacters(page)
    }
}