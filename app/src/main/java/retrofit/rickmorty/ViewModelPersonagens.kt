package retrofit.rickmorty

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ViewModelPersonagens : ViewModel() {
    val characterResponse = MutableLiveData<CharacterResponse>()
    private val repositoryRickMorty = RepositoryRickMorty()

    fun getCharacters(page: Int = 1) = CoroutineScope(IO).launch {
        characterResponse.postValue(repositoryRickMorty.getCharacters(page))
    }
}
