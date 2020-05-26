package custom

import com.example.exemplo.databinding.ExemploItemBinding
import custom.adapter.RecyclerViewBuilder

class ExemploViewBuilderKotlin : RecyclerViewBuilder<CharSequence, ExemploItemBinding>() {

    override val binding by lazy { bind(ExemploItemBinding::class) }

    override fun ExemploItemBinding.onBind(position: Int) {
        joaoTextview.text = collection.viewModel(position)
    }
}