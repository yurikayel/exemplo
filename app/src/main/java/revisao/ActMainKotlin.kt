package revisao

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.exemplo.R

class ActMainKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main_revisao)
        val onClick = View.OnClickListener { v -> startActivity(Intent(v.context, ActFragmentsRevisao::class.java)) }
        val text = "Bem vindo ${intent.extras!!.getString("nome")}! Clique abaixo para ver Fragmentos:"
        findViewById<TextView>(R.id.benvindo_nome).text = text
        findViewById<Button>(R.id.benvindo_button).setOnClickListener(onClick)
    }
}