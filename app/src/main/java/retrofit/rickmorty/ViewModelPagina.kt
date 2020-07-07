package retrofit.rickmorty

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import custom.async

class ViewModelPagina : ViewModel() {

    val characterResponse = MutableLiveData<CharacterResponse>()
    val repositoryRickMorty = RepositoryRickMorty()

    @VisibleForTesting
    fun getCharacters(page: Int = 1) = async {
        characterResponse.postValue(repositoryRickMorty.getCharacters(page))
    }

    @VisibleForTesting
    fun getAllCharacters() = async {
        characterResponse.postValue((repositoryRickMorty.getAllCharacters()))
    }
}
