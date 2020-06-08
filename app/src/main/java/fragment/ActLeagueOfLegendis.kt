package fragment

//import androidx.core.os.bundleOf
import android.os.Bundle
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import base.ActBase
import com.example.exemplo.R
import custom.onTextSubmit

private const val PLAYER_KEY = "PLAYER_NAME"

class ActLeagueOfLegendis : ActBase(R.layout.activity_main) {

    override fun ViewGroup.onView() {
        findViewById<SearchView>(R.id.search_id).setOnQueryTextListener(onTextSubmit {
            replaceFragment(FragVermelho.newInstance(Bundle().apply { putString(PLAYER_KEY, it) }))
        })
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().replace(R.id.container_id, fragment).commit()

}
