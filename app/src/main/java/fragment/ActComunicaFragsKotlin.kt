package fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.exemplo.R

class ActComunicaFragsKotlin : AppCompatActivity(), ActivityContract {

    private var fragVermelho: FragVermelho? = null
    private val fragVerde by lazy { findFrag<FragVerde>(R.id.frag_verde) }
    private lateinit var fragAzul: Fragment

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.act_comunica_frags)
        fragVermelho = findFrag(R.id.frag_vermelho)
        fragAzul = findFrag(R.id.frag_azul)
    }

    private fun <T> findFrag(fragID: Int) =
        supportFragmentManager.findFragmentById(fragID) as T

    override fun setTextVermelho(texto: String): Unit =
        fragVermelho!!.setTextVermelho(texto)

    override fun setTextVerde(texto: String) =
        fragVerde.setTextVerde(texto)

    override fun setTextAzul(texto: String) =
        (fragAzul as FragAzul).setTextAzul(texto)
}

