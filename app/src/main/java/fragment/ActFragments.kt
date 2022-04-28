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
    lateinit var bundleVermelho: Bundle
    lateinit var bundleVerde: Bundle
    lateinit var bundleAzul: Bundle
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
        bundleVermelho.putString("chave", "bundleVermelho")
        bundleVerde.putString("chave", "bundleVerde")
        bundleAzul.putString("chave", "bundleAzul")
    }

    private fun colocaClick() {
        clickBotao(vermelho, FragVermelho(bundleVermelho))
        clickBotao(verde, FragVerde.newInstance(bundleVerde))
        clickBotao(azul, FragAzul.newInstance(bundleAzul))
    }

    private fun clickBotao(button: Button?, fragment: Fragment) {
        button!!.setOnClickListener { carregaFrag(fragment) }
    }

    private fun carregaFrag(fragment: Fragment) {
        if (!voltaSeTiver(fragment.javaClass.name)) {
            supportFragmentManager
                .beginTransaction()  // Não sei, só sei que foi assim
                .replace(R.id.framelayout_amarelo, fragment)
                .addToBackStack(fragment.javaClass.name)
                .commit()
        }
    }

    private fun voltaSeTiver(fragName: String) =
        supportFragmentManager.popBackStackImmediate(fragName, 0)

    override fun setTextVermelho(texto: String) {
        brindaEEsconde()
    }

    override fun setTextVerde(texto: String) {
        brindaEEsconde()
    }

    override fun setTextAzul(texto: String) {
        brindaEEsconde()
    }

    private fun brindaEEsconde() {
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