package custom

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import custom.adapter.RecyclerViewBuilder
import custom.adapter.RecyclerViewHolder

fun <T> Collection<T>.get(index: Int): T {
    forEachIndexed { indexed, element -> if (indexed == index) return element }
    throw IndexOutOfBoundsException()
}

inline fun <reified Builder : RecyclerViewBuilder<*, *>> RecyclerView.setup(list: Collection<*>) =
    recyclerAdapter<Builder>(list).apply { adapter = this }

inline fun <reified Builder : RecyclerViewBuilder<*, *>> recyclerAdapter(collection: Collection<*>) =
    object : RecyclerAdapter<RecyclerViewHolder>(collection) {

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
            RecyclerViewHolder(
                Builder::class.java.newInstance().init(viewGroup, collection)
            )

        override fun getItemCount() = collection.size

        override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) =
            viewHolder.builder.bind(position)
    }

val RecyclerView.recyclerAdapter get() = adapter as RecyclerAdapter?

fun RecyclerView.update() = recyclerAdapter?.notifyDataSetChanged()

fun <T> MutableList<T>.update(collection: Collection<T>) {
    clear()
    collection.forEach { add(it) }
}

fun Activity.hideSoftKeyBoard() =
    (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?)?.run {
        if (currentFocus != null && isAcceptingText) {
            hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

val Int.isEven get() = this % 2 == 0

val Int.isOdd get() = this % 2 != 0

val EditText.string get() = text.toString()

val EditText.int get() = string.toInt()