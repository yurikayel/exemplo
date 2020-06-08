package viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class WhiskasPagerAdapter(
    private val fragmentArray: Array<Fragment>,
    private val nomes: List<String>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = fragmentArray[position]

    override fun getPageTitle(position: Int) = nomes[position]

    override fun getCount() = fragmentArray.size
}
