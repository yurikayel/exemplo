package custom

import android.view.View
import android.widget.TextView
import com.example.exemplo.R
import custom.adapter.RecyclerViewBuilder

class ExemploViewBuilderKotlin : RecyclerViewBuilder<CharSequence>() {

    override val layout = R.layout.exemplo_item

    override fun View.onBind(position: Int) {
        findViewById<TextView>(R.id.joao_textview).text = collection.get(position)
    }
}