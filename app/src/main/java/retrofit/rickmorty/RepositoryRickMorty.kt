package retrofit.rickmorty

import androidx.annotation.VisibleForTesting
import retrofit.Repository

class RepositoryRickMorty : Repository<ServiceRickMorty>(
    "https://rickandmortyapi.com/api/",
    ServiceRickMorty::class
) {
    @VisibleForTesting
    suspend fun getCharacters(page: Int = 1) = service.getCharacters(page)

    @VisibleForTesting
    suspend fun getAllCharacters(startingPage: Int = 1): CharacterResponse {
        val response = service.getCharacters(startingPage)
        response.info.pages.let {
            for (index in startingPage..it) {
                response.results.addAll(getCharacters(index).results)
            }
        }
        return response
    }
}
