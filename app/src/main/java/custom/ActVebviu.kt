package custom

import android.os.Bundle
import android.webkit.WebView
import base.ActBase

class ActVebviu : ActBase() {

    private val webView: WebView by lazy {
        PeterWebView(this, "https://www.google.com")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(webView)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }
}