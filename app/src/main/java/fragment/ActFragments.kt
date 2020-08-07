package fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.exemplo.R

class ActFragments : AppCompatActivity(), ActivityContract {
    var vermelho: Button? = null
    var verde: Button? = null
    var azul: Button? = null
    var bundleVermelho: Bundle? = null
    var bundleVerde: Bundle? = null
    var bundleAzul: Bundle? = null
    var manager = supportFragmentManager
    var toast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        achaViews()
        configuraPacote()
        colocaClick()
    }

    @SuppressLint("ShowToast") private fun achaViews() {
        setContentView(R.layout.act_fragments)
        vermelho = findViewById(R.id.button_vermelho)
        verde = findViewById(R.id.button_verde)
        azul = findViewById(R.id.button_azul)
        toast = Toast.makeText(this, "Ver ActComunicaFrags", Toast.LENGTH_SHORT)
    }

    private fun configuraPacote() {
        bundleVermelho = Bundle()
        bundleVerde = Bundle()
        bundleAzul = Bundle()
        bundleVermelho!!.putString("chave", "valor")
        bundleVerde!!.putString("chave", "valor")
        bundleAzul!!.putString("chave", "valor")
    }

    private fun colocaClick() {
        clickBotao(vermelho, FragVermelho.newInstance(bundleVermelho))
        clickBotao(verde, FragVerde.newInstance(bundleVerde))
        clickBotao(azul, FragAzul.newInstance(bundleAzul))
    }

    private fun clickBotao(button: Button?, fragment: Fragment) {
        button!!.setOnClickListener { carregaFrag(fragment) }
    }

    private fun carregaFrag(fragment: Fragment): Void? {
        val fragVoltou = voltaSeTiver(fragment.javaClass.name)
        if (!fragVoltou) manager
            .beginTransaction()
            .replace(R.id.framelayout_amarelo, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()
        return null
    }

    private fun voltaSeTiver(fragName: String): Boolean {
        return manager.popBackStackImmediate(fragName, 0)
    }

    override fun setTextVermelho(texto: String) {
        toast!!.show()
        hideSoftKeyBoard()
    }

    override fun setTextVerde(texto: String) {
        toast!!.show()
        hideSoftKeyBoard()
    }

    override fun setTextAzul(texto: String) {
        toast!!.show()
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