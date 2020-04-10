package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.exemplo.R

class ActFragmentsKotlin : AppCompatActivity() {

    private lateinit var vermelho: Button
    private lateinit var verde: Button
    private lateinit var azul: Button
    private lateinit var pacoteVermei: Bundle
    private lateinit var pacotePalmeirense: Bundle
    private lateinit var pacoteAzul: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        achaViews()
        configuraPacote()
        colocaClick()
    }

    private fun achaViews() {
        setContentView(R.layout.act_fragments)
        vermelho = findViewById(R.id.button_vermelho)
        verde = findViewById(R.id.button_verde)
        azul = findViewById(R.id.button_azul)
    }

    private fun configuraPacote() {
        pacoteVermei = Bundle()
        pacotePalmeirense = Bundle()
        pacoteAzul = Bundle()

        pacoteVermei.putString("chave", "Não, aí eu coloco a variavel")
        pacotePalmeirense.putString("chave", "Não tem o quê? Melhor não comentar")
        pacoteAzul.putString("chave", "Caneta Azul, Azul Caneeeetaaaaaaaa")
    }

    private fun colocaClick() {
        vermelho.clickBotao(FragVermelhoKotlin.newInstance(pacoteVermei))
        azul.clickBotao(FragAzul.newInstance(pacoteAzul))
        verde.clickBotao(FragVerde.newInstance(pacotePalmeirense))
    }

    private fun Button.clickBotao(frag: Fragment) = setOnClickListener {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout_amarelo, frag)
            .commit()
    }
}