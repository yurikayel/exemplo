package base

import binding.ActRafinha
import binding.ActSache
import binding.ActWhiskas
import com.example.exemplo.databinding.ActHostBinding
import custom.ActCrossMap
import custom.ItemViewActivity
import custom.setup
import dbroomkt.ActChamadaRoom
import dbsqlite.ActChamada
import debugging.ActDebugging
import drawer.ActDrawer
import fragment.ActComunicaFrags
import fragment.ActFragments
import fragment.ActFragmentsKotlin
import functions.ActExtension
import functions.ActLambda
import functions.ActReified
import intent.ActAzul
import intent.ActVerde
import intent.ActVermelha
import mvvm.ActArquitetura
import navdrawer.ActNavDrawer
import permissions.ActPermissions
import permissions.ActPermissionsJeitoChato
import recycler.ActRecycler
import retrofit.ActCorotina
import retrofit.ActPagina
import retrofit.ActRandom
import retrofit.ActRetroFit
import revisao.ActCadastro
import share.ActShare
import thread.ActThread
import viewpager.ActPager
import viewpager.ActViewPager

class ActHost : ActBind<ActHostBinding>() {

    override val binding: ActHostBinding by viewBind()

    private val list = listOf(
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
        ActPager::class,
        ActFragmentsKotlin::class,
        ActChamada::class,
        ActChamadaRoom::class,
        ActThread::class,
        ActArquitetura::class,
        ActRetroFit::class,
        ActRandom::class,
        ActCorotina::class,
        ActCrossMap::class,
        ActPagina::class,
        ActExtension::class,
        ActLambda::class,
        ActReified::class,
        ActPermissions::class,
        ActPermissionsJeitoChato::class,
        ActShare::class
    )

    override fun ActHostBinding.onBoundView() {
        actHostRecycler.setup<ItemViewActivity>(list)
    }
}