package viewpager

import base.ActBind
import com.example.exemplo.databinding.ActPagerBinding
import fragment.FragAzul
import fragment.FragVerde
import fragment.FragVermelho

class ActPager : ActBind<ActPagerBinding>(ActPagerBinding::class.java) {

    private val fragmentArray = arrayOf(FragAzul(), FragVermelho(), FragVerde())
    private val nomes = listOf("Xandão", "Rafão", "Peter Henry II")

    override fun ActPagerBinding.onBoundView() {
        whiskasTabLayout.setupWithViewPager(whiskasViewPager)
        whiskasViewPager.adapter = WhiskasPagerAdapter(fragmentArray, nomes, supportFragmentManager)
    }
}