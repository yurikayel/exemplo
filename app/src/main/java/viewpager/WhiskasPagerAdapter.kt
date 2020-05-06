package viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class WhiskasPagerAdapter(
    private val fragmentArray: Array<Fragment>,
    private val nomes: List<String>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = fragmentArray[position]

    override fun getPageTitle(position: Int) = nomes[position]

    override fun getCount() = fragmentArray.size
}
