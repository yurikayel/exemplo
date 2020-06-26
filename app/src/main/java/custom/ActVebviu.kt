package custom

import android.webkit.WebView
import base.ActBase

class ActVebviu : ActBase() {

    override val view: WebView by lazy {
        PeterWebView(this, "https://www.google.com")
    }

    override fun onBackPressed() {
        if (view.canGoBack()) view.goBack() else super.onBackPressed()
    }
}