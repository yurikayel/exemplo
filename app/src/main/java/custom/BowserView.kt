package custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout

fun View.bowserView(urlString: String = "https://pt.wikipedia.org/wiki/Sua_M%C3%A3e") =
    BowserView(context, urlString)

class BowserView @JvmOverloads constructor(
    context: Context,
    private val urlString: String = "https://www.google.com",
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val searchBox by lazy { EditText(context) }
    private val webView by lazy { PeterWebView(context, urlString) }

    @SuppressLint("ClickableViewAccessibility")
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        orientation = VERTICAL
        addView(searchBox)
        addView(webView)
        searchBox.setOnTouchListener { _, _ ->
            searchBox.setText("")
            false
        }
        searchBox.inputType = EditorInfo.TYPE_TEXT_VARIATION_URI
        searchBox.onKey {
            when (it) {
                KEYCODE_ENTER -> webView.loadUrl("https://www.${searchBox.text}")
            }
        }
        webView.onUrlChanged = { searchBox.setText(it) }
    }

    override fun onCheckIsTextEditor() = true

    val canGoBack get() = webView.canGoBack()

    fun goBack() = webView.goBack()
}