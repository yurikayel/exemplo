package custom

import base.ActBind
import binding.ActRafinha
import binding.ActSache
import binding.ActWhiskas
import com.example.exemplo.databinding.ActHostBinding
import debugging.ActDebugging
import drawer.ActDrawer
import fragment.ActComunicaFrags
import fragment.ActFragments
import intent.ActAzul
import intent.ActVerde
import intent.ActVermelha
import navdrawer.ActNavDrawer
import recycler.ActRecycler
import revisao.ActCadastro
import viewpager.ActPager
import viewpager.ActViewPager

class ActHost : ActBind<ActHostBinding>(ActHostBinding::class.java) {

    override fun ActHostBinding.onBoundView() {
        actHostRecycler.setRecyclerAdapter<ActHostItemBuilder>(
            listOf(
                ActVermelha::class,
                ActVerde::class,
                ActAzul::class,
                ActFragments::class,
                ActComunicaFrags::class,
                ActCadastro::class,
                ActDrawer::class,
                ActNavDrawer::class,
                ActRecycler::class,
                ActWhiskas::class,
                ActSache::class,
                ActDebugging::class,
                ActRafinha::class,
                ActViewPager::class,
                ActPager::class
            )
        )
    }
}