package custom

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.res.Resources.getSystem
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import custom.adapter.ItemViewBuilder

operator fun <T> Collection<T>.get(index: Int): T {
    forEachIndexed { indexed, element -> if (indexed == index) return element }
    throw IndexOutOfBoundsException()
}

inline fun <reified Builder : ItemViewBuilder<*, *>>
        RecyclerView.setup(list: Collection<*>) =
    recyclerAdapter<Builder>(list).apply { adapter = this }

val RecyclerView.recyclerAdapter get() = adapter as RecyclerAdapter?

fun RecyclerView.update() = recyclerAdapter?.notifyDataSetChanged()

fun <T> MutableList<T>.update(collection: MutableList<T>) {
    clear()
    collection.forEach { add(it) }
}

fun Activity.hideKeyBoard() {
    (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?)
        ?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

val Int.isEven get() = this % 2 == 0

val Int.isOdd get() = this % 2 != 0

val EditText.string get() = text.toString()

val EditText.int get() = string.toInt()

private var toast: Toast? = null

fun Context.toast(message: String) {
    toast?.cancel()
    toast = Toast.makeText(this, message, LENGTH_SHORT)
    toast?.show()
}

fun String.isDigit(): Boolean {
    for (char in this) {
        if (!char.isDigit()) return false
    }
    return true
}

inline fun <reified Model : ViewModel> FragmentActivity.viewModel(): Model =
    ViewModelProviders.of(this).get(Model::class.java)

inline fun <reified Model : ViewModel> Fragment.viewModel(): Model =
    ViewModelProviders.of(this).get(Model::class.java)

fun <T : Comparable<T>> listOfRange(iterable: Iterable<T>): MutableList<T> {
    val list = mutableListOf<T>()
    iterable.forEach { list.add(it) }
    return list
}

@Suppress("UNCHECKED_CAST")
val <Type : Number> Type.dp
    get() = (toFloat() * getSystem().displayMetrics.density) as Type

@Suppress("UNCHECKED_CAST")
val <Type : Number> Type.dpToPx
    get() = (toFloat() / getSystem().displayMetrics.density) as Type

//@Suppress("UNCHECKED_CAST")
//val <Type : Number> Type.dp get() = (toFloat() * getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT) as Type
//
//@Suppress("UNCHECKED_CAST")
//val <Type: Number> Type.dpToPx get() = (toFloat() / getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT) as Type

fun onTextSubmit(block: (String) -> Unit) = object : SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(dota: String): Boolean {
        block(dota)
        return false
    }

    override fun onQueryTextChange(s: String): Boolean {
        return false
    }
}

fun Context.newButton(style: Int = 0) =
    Button(this, null, 0, style)

// reflexão é uma forma da linguagem referenciar a própria linguagem
// é uma forma de via código saber o que define uma classe
inline fun <reified ViewType : View> Context.new(
    style: Int,
    setup: ViewType.() -> Unit = {}
): ViewType {
    val view = ViewType::class.java.getConstructor(
        Context::class.java,
        AttributeSet::class.java,
        Int::class.java,
        Int::class.java
    ).newInstance(this, null, 0, style)
    view.setup()
    return view
}

fun <UmTipoDeView : View> UmTipoDeView.onClick(function: UmTipoDeView.() -> Unit) {
    setOnClickListener { function() }
}














