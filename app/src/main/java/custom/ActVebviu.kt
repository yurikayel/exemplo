package custom

import base.ActBase

class ActVebviu : ActBase() {

    override val view by lazy {
        BowserView(this, "https://pt.wikipedia.org/wiki/Sua_M%C3%A3e")
    }

    override fun onBackPressed() {
        if (view.canGoBack) view.goBack() else super.onBackPressed()
    }
}