package custom

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.res.Resources.getSystem
import android.net.Uri
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.exemplo.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import custom.adapter.ItemViewBuilder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.*
import kotlin.reflect.KClass
import kotlin.reflect.KFunction0


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

fun <T : Comparable<T>> listOfRange(iterable: Iterable<T>): MutableList<T> {
    val list = mutableListOf<T>()
    iterable.forEach { list.add(it) }
    return list
}

@Suppress("UNCHECKED_CAST") // Converts Pixel value to DensityPixel value
val <N : Number> N.dp
    get() = (toFloat() * getSystem().displayMetrics.density) as N

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
    style: Int = R.style.Button,
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

fun <V : View> V.onClick(function: V.() -> Unit = {}) {
    setOnClickListener { function() }
}

fun <V : View> V.onClick(function: KFunction0<*>) {
    setOnClickListener { function() }
}


val Context.inflater get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

@Suppress("UNCHECKED_CAST")
inline fun <reified Binding : ViewBinding> IContext.viewBind() = lazy {
    Binding::class.java.getMethod("inflate", LayoutInflater::class.java)
            .invoke(null, activity.inflater) as Binding
}

@Suppress("UNCHECKED_CAST")
fun <Binding : ViewBinding> Context.viewBind(klass: KClass<Binding>) =
    klass.java.getMethod("inflate", LayoutInflater::class.java)
            .invoke(null, inflater) as Binding

fun Context.shareText(text: String) {
    startActivity(
        Intent.createChooser(
            Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
            }, "Whiskas Sache"
        )
    )
}

infix fun ImageView.setImageFromURL(url: Any?) = Picasso.get().load(url.toString()).into(this)

@Suppress("UNCHECKED_CAST")
val <T : Any> Class<T>.klass: KClass<T>
    get() = this::class as KClass<T>

fun Context.toFile(text: String, name: String = "config.txt") = try {
    OutputStreamWriter(openFileOutput(name, MODE_PRIVATE)).run {
        write(text)
        close()
    }
    "Wrote file:\n\n$text"
} catch (ioException: IOException) {
    "File write failed: $ioException"
}

fun Context.fromFile(name: String = "config.txt") = try {
    val input = openFileInput(name)
    val reader = BufferedReader(InputStreamReader(input))
    val builder = StringBuilder()
    while (reader.readLine() != null) {
        builder.append(reader.readLine())
    }
    input.close()
    builder.toString()
} catch (notFound: FileNotFoundException) {
    "File not found: $notFound"
} catch (ioException: IOException) {
    "Can not read file: $ioException"
}

fun <T> T.toJson(): String = GsonBuilder().setPrettyPrinting().create().toJson(this)

val <T : Parcelable> Array<T>.toJson get(): String = toJson()

val <T : Map<*, Parcelable>> T.toJson get(): String = toJson()

val <T : Iterable<Parcelable>> T.toJson get(): String = toJson()

inline fun <reified T> String.toObjekt(): T =
    Gson().fromJson(this, T::class.java)

inline fun <reified T> String.toObjekts(): T =
    Gson().fromJson(this, object : TypeToken<T>() {}.type)

fun Context.vamoLa(ondeNoizVai: String) = startActivity(
    Intent(
        Intent.ACTION_VIEW,
        Uri.parse("geo:0,0?q=$ondeNoizVai")
    ).setPackage("com.google.android.apps.maps")
)

const val DEFAULT_ANIM_DURATION: Long = 500

fun View.animateExpand(
    expand: Boolean = true,
    duration: Long = 500,
    vertical: Boolean = true
) =
    AnimatorSet().run {
        interpolator = AccelerateDecelerateInterpolator()
        play(
            ValueAnimator.ofInt(
                if (vertical) height else width,
                newSizeValue(expand, vertical)
            ).apply {
                this.duration = duration
                addUpdateListener(this, vertical)
            })
        start()
    }

private fun View.newSizeValue(expand: Boolean, vertical: Boolean) = if (!expand) 0 else {
    measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    if (vertical) measuredHeight else measuredWidth
}

fun View.addUpdateListener(valueAnimator: ValueAnimator, vertical: Boolean) =
    valueAnimator.addUpdateListener { animator ->
        (animator.animatedValue as Int).let {
            if (vertical) layoutParams.height = it else layoutParams.width = it
        }
        requestLayout()
    }

fun WebView.loadInApp(inApp: Boolean = true) {
    if (inApp) {
        webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
    }
}

fun EditText.onKey(onKeyCode: (keyCode: Int) -> Unit) {
    setOnKeyListener { _, keyCode, _ ->
        onKeyCode(keyCode)
        false
    }
}

fun async(
    dispatcher: CoroutineDispatcher = IO,
    block: suspend CoroutineScope.() -> Unit
) =
    CoroutineScope(dispatcher).launch(block = block)

inline fun <reified T>
        T.log(
    info: String = T::class.java.enclosingMethod?.name ?: T::class.java.simpleName
) =
    Log.i(T::class.java.simpleName, info)