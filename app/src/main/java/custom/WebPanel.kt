package custom

import android.content.Context
import android.content.DialogInterface.OnShowListener
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.example.exemplo.R

fun View.webPanel(url: String, onShow: OnShowListener? = null, init: (WebPanel) -> Unit = {}) =
    WebPanel(context, url, onShow, init)

class WebPanel(
    context: Context,
    url: String,
    onShow: OnShowListener? = null,
    init: (WebPanel) -> Unit = {}
) : AppCompatDialog(context, R.style.Panel) {

    private val web by lazy { PeterWebView(context, url) }

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(web)
        init(this)
        setOnShowListener(onShow)
        show()
    }

    override fun onBackPressed() = if (web.canGoBack()) web.goBack() else super.onBackPressed()
}