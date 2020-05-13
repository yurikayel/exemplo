package data

import com.example.exemplo.R
import com.example.exemplo.databinding.ItemChamadaBinding
import custom.adapter.RecyclerViewBuilder
import custom.get
import custom.isEven

class ChamadaViewBuilder : RecyclerViewBuilder<Pessoa, ItemChamadaBinding>() {

    override val bindClass = ItemChamadaBinding::class.java

    override fun ItemChamadaBinding.onBind(position: Int) {
        root.setBackgroundColor(context.getColor(if (position.isEven) R.color.amber_50 else R.color.indigo_50))

        collection.get(position).run {
            chamadaItemNome.text = nome
            chamadaItemSobrenome.text = sobrenome
            chamadaItemIdade.text = idade.toString()
            chamadaItemId.text = id.toString()
        }
    }

}
