package custom

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatDialog
import android.support.v7.widget.CardView
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.example.exemplo.R

class AppDialog(
    context: Context,
    onShow: DialogInterface.OnShowListener? = null,
    init: (AppDialog.() -> Unit) = {}
) : AppCompatDialog(context) {

    var title = TextView(context, null, 0, R.style.AppDialogTitle)

    var subTitle = TextView(context, null, 0, R.style.AppDialogSubTitle)

    var message = TextView(context, null, 0, R.style.AppDialogMessage)

    var positive = Button(context, null, 0, R.style.AppDialogButtonPositive)

    var neutral = Button(context, null, 0, R.style.AppDialogButton)

    var negative = Button(context, null, 0, R.style.AppDialogButton)

    var contentView = CardView(context).apply {
        val margin = 32.dp
        radius = 16f
        layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            setMargins(margin, margin, margin, margin)
        }

        addView(FrameLayout(context, null, 0, R.style.AppCardView).apply {
            addView(LinearLayout(context, null, 0, R.style.LinearVertical).apply {
                addView(title)
                addView(subTitle)
                addView(message)

                addView(LinearLayout(context, null, 0, R.style.LinearHorizontal).apply {
                    addView(neutral)
                    addView(View(context).apply {
                        layoutParams = LinearLayout.LayoutParams(0, 0).apply { weight = 1f }
                    })
                    addView(negative)
                    addView(positive)
                })
            })
        })
    }

    init {
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(contentView)
        init(this)
        setOnShowListener(onShow)
        listOf(title, subTitle, message, neutral, negative, positive).forEach {
            if (it.text.isNullOrEmpty()) it.visibility = GONE
        }
        show()
    }
}