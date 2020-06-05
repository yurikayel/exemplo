package retrofit

import android.arch.lifecycle.Observer
import base.ActBind
import com.example.exemplo.databinding.ActPaginaBinding
import custom.recyclerAdapter
import custom.viewModel
import retrofit.rickmorty.CharacterResponse.Result
import retrofit.rickmorty.ViewModelPersonagens

class ActPagina : ActBind<ActPaginaBinding>() {

    override val binding: ActPaginaBinding by viewBind()
    val viewModel by lazy { viewModel<ViewModelPersonagens>() }
    val set = mutableSetOf<Result>()
    var pagina = 1
    var totalPaginas = 30

    override fun ActPaginaBinding.onBoundView() {
        val adapter = recyclerAdapter<ItemViewPersonagem>(set)

        adapter.onTarget = {
            while (pagina < totalPaginas) {
                pagina += 1
                viewModel.getCharacters(pagina)
            }
        }

        paginaRecycler.adapter = adapter

        viewModel.characterResponse.observe(
            this@ActPagina,
            Observer {
                it?.run {
                    totalPaginas = info.pages
                    set.addAll(results)
                    adapter.notifyDataSetChanged()
                }
            })

        viewModel.getCharacters()
    }
}