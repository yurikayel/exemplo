package revisao

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exemplo.R

class ActCadastroKotlin : AppCompatActivity() {
    private lateinit var nome: EditText
    private lateinit var email: EditText
    private lateinit var senha: EditText
    private lateinit var cadastrar: Button

    private fun todosPreenchidos(vararg listaDeCamposDeTexto: EditText): Boolean {
        listaDeCamposDeTexto.forEach { if (it.text.toString().isEmpty()) return false }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_cadastro_revisao)
        nome = findViewById(R.id.cadastro_nome)
        email = findViewById(R.id.cadastro_email)
        senha = findViewById(R.id.cadastro_senha)
        cadastrar = findViewById(R.id.cadastro_cadastrar)
        cadastrar.setOnClickListener { view ->
            if (todosPreenchidos(nome, email, senha)) {
                Toast.makeText(view.context, "OK!", Toast.LENGTH_LONG).show()
                startActivity(
                    Intent(
                        view.context,
                        ActRevisaoFrags::class.java
                    ).putExtra("nome", nome.text.toString())
                )
            } else {
                Toast.makeText(view.context, "Faltou preencher aí!", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}