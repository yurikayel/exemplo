package retrofit.rickmorty

import kotlinx.coroutines.runBlocking
import org.junit.Test

class ViewModelPaginaTest {

    private val viewModel = ViewModelPagina()

    @Test
    fun getCharactersTest() {
        viewModel.getCharacters()
    }

    @Test
    fun getAllCharactersTest() {
        viewModel.getAllCharacters()
    }

    @Test
    fun repositoryTest() {
        runBlocking {
            viewModel.repositoryRickMorty.getAllCharacters().run {
                assert(results.elementAt(results.size - 1).id == info.count)
            }
        }
    }
}
