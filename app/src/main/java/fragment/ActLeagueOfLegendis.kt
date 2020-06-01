package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.SearchView
//import androidx.core.os.bundleOf
import base.ActBase
import com.example.exemplo.R
import custom.onTextSubmit

private const val PLAYER_KEY = "PLAYER_NAME"

class ActLeagueOfLegendis : ActBase(R.layout.activity_main) {

    override fun onView() {
        findViewById<SearchView>(R.id.search_id).setOnQueryTextListener(onTextSubmit {
            replaceFragment(FragVermelho.newInstance(Bundle().apply { putString(PLAYER_KEY, it) }))
        })
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().replace(R.id.container_id, fragment).commit()

}
