package firebase.analytics

import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import base.ActBase
import com.example.exemplo.R
import custom.new
import custom.onClick
import debugging.RafinhaException

class ActAnalytics : ActBase() {

    override val view by lazy { new<LinearLayout>(R.style.LinearVertical) }

    override fun ViewGroup.onView() {
        addView(new<Button> {
            text = context.getString(R.string.rafinha_exception)
            onClick { throw RafinhaException() }
        })
    }

}