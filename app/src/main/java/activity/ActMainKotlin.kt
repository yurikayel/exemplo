package activity

import android.app.Activity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import com.example.exemplo.R

class ActMainKotlin : Activity() {

    private val textoVazio = ""

    private val onClick = OnClickListener {
        makeText(
            this,
            if (todosTemTexto(
                    R.id.edit_nome,
                    R.id.edit_email,
                    R.id.edit_endereco,
                    R.id.edit_profissao
                )
            ) "OK!" else "Favor preencher todos os campos!",
            LENGTH_LONG
        ).show()
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_enviar).setOnClickListener(onClick)
    }

    private fun todosTemTexto(vararg editTexts: Int): Boolean {
        editTexts.forEach { if (textoVazio.contentEquals(findViewById<EditText>(it).text)) return false }
        return true
    }
}