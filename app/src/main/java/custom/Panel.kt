package custom

import android.content.Context
import android.content.DialogInterface.OnShowListener
import android.support.v7.app.AppCompatDialog
import android.view.View
import android.view.Window.FEATURE_NO_TITLE
import com.example.exemplo.R

fun View.newPanel(
    layout: Int = R.layout.panel,
    onShow: OnShowListener? = null,
    init: (Panel.() -> Unit) = {}
) = Panel(context, onShow, init, layout).apply { show() }

class Panel(
    context: Context,
    onShow: OnShowListener? = null,
    init: (Panel.() -> Unit),
    layout: Int
) : AppCompatDialog(context, R.style.Panel) {

    init {
        requestWindowFeature(FEATURE_NO_TITLE)
        setContentView(layout)
        init(this)
        setOnShowListener(onShow)
    }
}