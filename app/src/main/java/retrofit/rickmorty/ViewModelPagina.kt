package retrofit.rickmorty

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ViewModelPagina : ViewModel() {
    val characterResponse = MutableLiveData<CharacterResponse>()
    private val repositoryRickMorty = RepositoryRickMorty()

    fun getCharacters(page: Int = 1) = CoroutineScope(IO).launch {
        characterResponse.postValue(repositoryRickMorty.getCharacters(((page))))
    }

    fun teste() {

        val set = setOf(1, 2, 3, 4)
        val mutableSet = mutableSetOf(5, 6, 7, 8)

        mutableSet.addAll(set)
    }
}
