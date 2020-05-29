package retrofit

import com.example.exemplo.R
import com.example.exemplo.databinding.ItemPersonagemBinding
import com.squareup.picasso.Picasso
import custom.adapter.ItemViewBuilder
import custom.isEven
import retrofit.rickmorty.CharacterResponse.Result

class ItemViewPersonagem : ItemViewBuilder<Result, ItemPersonagemBinding>() {

    override val binding by lazy { bind(ItemPersonagemBinding::class) }

    override fun ItemPersonagemBinding.onBind(position: Int) {
        root.setBackgroundColor(context.getColor(if (position.isEven) R.color.amber_50 else R.color.indigo_50))

        (collection as Set<Result>).elementAt(position).run {
            Picasso.get().load(image).into(itemPersonaImage)
            itemPersonaName.text = name
        }
    }
}
