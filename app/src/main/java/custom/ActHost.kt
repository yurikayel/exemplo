package custom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.LinearLayout.VERTICAL
import binding.ActSache
import binding.ActWhiskas
import com.example.exemplo.R
import custom.adapter.RecyclerViewBuilder
import custom.adapter.recyclerAdapter
import drawer.ActDrawer
import fragment.ActComunicaFrags
import fragment.ActFragments
import intent.ActAzul
import intent.ActVerde
import intent.ActVermelha
import navdrawer.ActNavDrawer
import recycler.ActRecycler
import revisao.ActCadastro
import kotlin.reflect.KClass

class ActHost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_host)
        findViewById<RecyclerView>(R.id.act_host_recycler).run {
            layoutManager = LinearLayoutManager(this@ActHost, VERTICAL, false)
            adapter = recyclerAdapter<ClassViewBuilder>(
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
                    ActSache::class
                )
            )
        }
    }
}

class ClassViewBuilder : RecyclerViewBuilder<KClass<AppCompatActivity>>() {
    override val layout = R.layout.act_host_button

    override fun View.onBind(position: Int) {
        collection.get(position).run {
            findViewById<Button>(R.id.act_host_button).run {
                text = java.name
                setOnClickListener { context.startActivity(Intent(context, java)) }
            }
        }
    }
}

private fun <T> Collection<T>.get(index: Int): T {
    forEachIndexed { indexed, element -> if (indexed == index) return element }
    throw IndexOutOfBoundsException()
}
