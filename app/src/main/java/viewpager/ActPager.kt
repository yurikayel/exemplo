package viewpager

import base.ActBind
import com.example.exemplo.databinding.ActPagerBinding
import custom.setup
import fragment.FragAzul
import fragment.FragVerde
import fragment.FragVermelho

class ActPager : ActBind<ActPagerBinding>() {

    override val binding: ActPagerBinding by viewBind()

    private val fragmentArray = arrayOf(FragAzul(), FragVermelho(), FragVerde())
    private val nomes = listOf("Xandão", "Rafão", "Peter Henry II")

    override fun ActPagerBinding.onBoundView() {
        viewPager.setup(fragmentArray, nomes, tabLayout)
    }
}