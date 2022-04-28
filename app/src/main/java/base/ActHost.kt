package base

import activity.ActCicloDeVida
import activity.ActMainJava
import activity.ActMainKotlin
import binding.ActRafinha
import binding.ActSache
import binding.ActWhiskas
import com.example.exemplo.databinding.ActHostBinding
import custom.*
import dbroomkt.ActChamadaRoom
import dbsqlite.ActChamada
import debugging.ActDebugging
import drawer.ActDrawer
import facebook.ActFacebook
import firebase.analytics.ActAnalytics
import firebase.database.ActFireDatabase
import firebase.login.ActFirebaseLogin
import firebase.storage.ActFirebaseStorage
import fragment.ActComunicaFrags
import fragment.ActFragments
import fragment.ActFragmentsKotlin
import functions.ActExtension
import functions.ActLambda
import functions.ActReified
import intent.ActAzul
import intent.ActExemplo
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
import sharedpref.ActSharedPref
import thread.ActThread
import viewpager.ActPager
import viewpager.ActViewPager

class ActHost : ActBind<ActHostBinding>() {

    override val binding: ActHostBinding by viewBind()

    private val list = listOf(
        ActMainJava::class,
        ActMainKotlin::class,
        ActExemplo::class,
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
        ActShare::class,
        ActFacebook::class,
        ActFirebaseLogin::class,
        ActFirebaseStorage::class,
        ActAnalytics::class,
        ActFireDatabase::class,
        ActDropDown::class,
        ActVebviu::class,
        ActBowserView::class,
        ActSharedPref::class
    )

    override fun ActHostBinding.onBoundView() {
        actHostRecycler.setup<ItemViewActivity>(list)
    }
}