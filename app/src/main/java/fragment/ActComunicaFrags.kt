package fragment

import custom.hideKeyBoard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exemplo.R

class ActComunicaFrags : AppCompatActivity(), ActivityContract {

    var fragManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_comunica_frags)
    }

    override fun setTextVermelho(texto: String) {
        (fragManager.findFragmentById(R.id.frag_vermelho) as FragVermelho).setTextVermelho(texto)
        hideKeyBoard()
    }

    override fun setTextVerde(texto: String) {
        (fragManager.findFragmentById(R.id.frag_verde) as FragVerde).setTextVerde(texto)
        hideKeyBoard()
    }

    override fun setTextAzul(texto: String) {
        (fragManager.findFragmentById(R.id.frag_azul) as FragAzul).setTextAzul(texto)
        hideKeyBoard()
    }
}