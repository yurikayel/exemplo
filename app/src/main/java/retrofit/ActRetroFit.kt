package retrofit

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import base.ActBase
import custom.VerticalRecycler
import custom.listOfRange
import custom.setup

class ActRetroFit : ActBase() {

    val list = listOfRange('A'..'Z')
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = VerticalRecycler(this)
        recyclerView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        recyclerView.setup<RetroItemViewBuilder<Char>>(list)
        setContentView(recyclerView)
    }
}
