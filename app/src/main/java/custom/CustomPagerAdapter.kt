package custom

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

fun ViewPager.setupPagerAdapter(collection: Any, titles: List<String>) {
    adapter = CustomPagerAdapter(collection, titles, (context as AppCompatActivity).supportFragmentManager)
}

class CustomPagerAdapter(
    private val collection: Any,
    private val titles: List<String>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    @Suppress("UNCHECKED_CAST")
    override fun getItem(position: Int) = when (collection) {
        is List<*> -> collection[position] as Fragment
        is Array<*> -> collection[position] as Fragment
        else -> null
    }

    override fun getPageTitle(position: Int) = titles[position]

    override fun getCount() = titles.size
}

