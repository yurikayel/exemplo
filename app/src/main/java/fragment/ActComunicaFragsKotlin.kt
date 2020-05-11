package fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.example.exemplo.R

class ActComunicaFragsKotlin : AppCompatActivity(), ActivityContract {
    var fragVermelho: FragVermelho? = null
    var fragVerde: FragVerde? = null
    var fragAzul: FragAzul? = null
    var fragManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_comunica_frags)
        fragVermelho = fragManager.findFragmentById(R.id.frag_vermelho) as FragVermelho?
        fragVerde = fragManager.findFragmentById(R.id.frag_verde) as FragVerde?
        fragAzul = fragManager.findFragmentById(R.id.frag_azul) as FragAzul?
    }

    override fun setTextVermelho(texto: String) {
        fragVermelho!!.setTextVermelho(texto)
        hideSoftKeyBoard()
    }

    override fun setTextVerde(texto: String) {
        fragVerde!!.setTextVerde(texto)
        hideSoftKeyBoard()
    }

    override fun setTextAzul(texto: String) {
        fragAzul!!.setTextAzul(texto)
        hideSoftKeyBoard()
    }

    private fun hideSoftKeyBoard() {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm != null && currentFocus != null && imm.isAcceptingText) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }
}