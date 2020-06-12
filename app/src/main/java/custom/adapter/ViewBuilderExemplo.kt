package custom.adapter

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.Toast
import com.example.exemplo.databinding.RecyclerViewItemBinding
import custom.viewBind

class ViewBuilderExemplo : ItemViewBuilder<String, RecyclerViewItemBinding>() {

    override val binding: RecyclerViewItemBinding by viewBind()

    override fun RecyclerViewItemBinding.onBind(position: Int) {
        val string = collection.get(position)

        whiskasText.run {
            text = string
            onClick { toast(string) }
        }
    }
}

//  EXTENSION FUNCTIONS

private fun <T> Collection<T>.get(index: Int): T? {
    forEachIndexed { indexed, element -> if (indexed == index) return element }
    throw IndexOutOfBoundsException()
}

private fun View.stringAny(text: Any?): CharSequence = when (text) {
    is String -> text
    is CharSequence -> text
    is Int -> context.getResourceOrToString(text)
    else -> ""
}

private fun Context.getResourceOrToString(text: Int) = try {
    getString(text)
} catch (ex: Resources.NotFoundException) {
    text.toString()
}

private fun View.onClick(block: View.() -> Unit) = setOnClickListener { block.invoke(this) }

private fun View.toast(message: Any?) =
    Toast.makeText(context, stringAny(message), Toast.LENGTH_LONG).show()