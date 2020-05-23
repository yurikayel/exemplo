package retrofit

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import base.ActBase
import custom.VerticalRecycler
import custom.setup

class ActRetroFit : ActBase() {

    override val layout by lazy {
        VerticalRecycler(this).setup<RetroItemViewBuilder>(mutableListOf<Int>().apply {
            (1..9999).forEach { add(it) }
        }).apply { layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT) }
    }
}