package custom

import android.widget.Button
import base.ActBase

private const val url = "https://pt.wikipedia.org/wiki/Sua_M%C3%A3e"

class ActBowserView : ActBase() {

    override val view by lazy {
        Button(this).apply {
            text = "Abrir BowserView em um Panel"
            onClick { newPanel(bowserView()) }
        }
    }
}

