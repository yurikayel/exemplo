package revisao

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.exemplo.R
import android.content.Intent
import android.view.View
import kotlin.reflect.KClass

class ActRevisaoFrags : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main_revisao)

        val textoFormatado =
            "Bem vindo(a) ${intent.extras?.getString("nome") ?: "Gunther"}! Clique abaixo para ver Fragmentos:"

        findViewById<TextView>(R.id.benvindo_nome).text = textoFormatado

        findViewById<View>(R.id.benvindo_button).setOnClickListener { view ->
            view.start(ActFragmentsRevisao::class)
        }

        findViewById<View>(R.id.benvindo_button_comunica_frags).setOnClickListener {
            it.start(ActComunicaFragsRevisao::class)
        }
    }

    private fun <T : Activity> View.start(klass: KClass<T>) =
        startActivity(Intent(context, klass.java))
}