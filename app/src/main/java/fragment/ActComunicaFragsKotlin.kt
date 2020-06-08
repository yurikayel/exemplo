package fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.exemplo.R
import custom.hideKeyBoard

class ActComunicaFragsKotlin : AppCompatActivity(), ActivityContract {

    // Postergar inicialização = lateinit
    // lateinit se usa para não declarar um objeto como nulável
    // ou seja, invariavelmente o objeto sempre vai ter um valor
    private var fragVermelho: FragVermelho? = null
    private lateinit var fragVerde: Fragment
    private lateinit var fragAzul: FragAzul

    private val fragManager : FragmentManager = supportFragmentManager

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.act_comunica_frags)
        fragVermelho = fragManager.findFragmentById(R.id.frag_vermelho) as FragVermelho?
        fragVerde = findFrag<FragVerde>(R.id.frag_verde)
        fragAzul = fragManager.findFragmentById(R.id.frag_azul) as FragAzul
    }

    @Suppress("UNCHECKED_CAST")
    private fun <Tipo> findFrag(fragID : Int) = fragManager.findFragmentById(fragID) as Tipo

    override fun setTextVermelho(texto: String) {
        fragVermelho?.setTextVermelho(texto)
//        É o mesmo que:
//        if(fragVermelho != null){
//            fragVermelho.setTextVermelho(texto)
//        }
        hideKeyBoard()
    }

    override fun setTextVerde(texto: String) {
        (fragVerde as FragVerde).setTextVerde(texto)
        hideKeyBoard()
    }

    override fun setTextAzul(texto: String) {
        fragAzul.setTextAzul(texto)
        hideKeyBoard()
    }
}