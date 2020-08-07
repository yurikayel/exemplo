package viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.exemplo.R
import com.google.android.material.tabs.TabLayout
import fragment.FragAzul
import fragment.FragVerde
import fragment.FragVermelho

class ActViewPager : AppCompatActivity() {

    private val pager by lazy {
        findViewById<ViewPager>(R.id.view_pager)
    }
    private val tab by lazy {
        findViewById<TabLayout>(R.id.tab_layout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_pager)

        tab.setupWithViewPager(pager)
        pager.adapter = ExemploAdapter(
            listOf(
                FragVermelho.newInstance(),
                FragVerde.newInstance(Bundle()),
                FragAzul.newInstance(Bundle())
            ),
            listOf(
                "Xandão",
                "Rafão",
                "Peter Henry II"
            ),
            supportFragmentManager
        )
    }
}