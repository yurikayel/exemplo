package fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.example.exemplo.R

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
        escondeTeclado()
    }

    override fun setTextVerde(texto: String) {
        (fragVerde as FragVerde).setTextVerde(texto)
        escondeTeclado()
    }

    override fun setTextAzul(texto: String) {
        fragAzul.setTextAzul(texto)
        escondeTeclado()
    }

    private fun escondeTeclado() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm != null && currentFocus != null && imm.isAcceptingText) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }
}