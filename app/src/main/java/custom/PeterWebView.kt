package custom

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient

class PeterWebView @JvmOverloads constructor(
    context: Context,
    private val startURL: String = "https://www.google.com",
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    private var firstLoad = true

    var onUrlChanged: (String) -> Unit = {}

    var currentURL = startURL
        set(value) {
            field = value
            onUrlChanged(value)
        }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        loadUrl(startURL)
        webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                if (firstLoad) {
                    firstLoad = false
                } else currentURL = url
                super.onPageFinished(view, url)
            }
        }
        settings.javaScriptEnabled = true
        isFocusable = true
        isFocusableInTouchMode = true
    }

    override fun onCheckIsTextEditor() = true

}