package custom

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

fun ViewPager.setupPagerAdapter(frags: Any, titles: Any) {
    adapter = CustomPagerAdapter(
        frags, titles, (context as AppCompatActivity).supportFragmentManager
    )
}

class CustomPagerAdapter(
    private val frags: Any,
    private val titles: Any,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    @Suppress("UNCHECKED_CAST")
    override fun getItem(position: Int) = when (frags) {
        is List<*> -> frags[position] as Fragment
        is Array<*> -> frags[position] as Fragment
        else -> null
    }

    override fun getPageTitle(position: Int) = when (titles) {
        is List<*> -> titles[position] as String
        is Array<*> -> titles[position] as String
        else -> null
    }

    override fun getCount() = when (frags) {
        is List<*> -> frags.size
        is Array<*> -> frags.size
        else -> when (titles) {
            is List<*> -> titles.size
            is Array<*> -> titles.size
            else -> 2
        }
    }
}

