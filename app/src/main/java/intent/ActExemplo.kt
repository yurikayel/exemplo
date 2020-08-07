package intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.exemplo.R

class ActExemplo : AppCompatActivity() {

    //  Chamado na criação da activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onViews()
        val extras = intent.extras

        val string = extras?.getString("chave0")
        val int = extras?.getInt("chave1")
        val float = extras?.getFloat("chave2")
        val double = extras?.getDouble("chave3")
        val boolean = extras?.getBoolean("chave4")
    }

    private fun onViews() {
        setContentView(R.layout.act_exemplo)
        val botao: Button = findViewById(R.id.button)
        val texto: TextView = findViewById(R.id.textView)
        val edit: EditText = findViewById(R.id.edittext)
        val image: ImageView = findViewById(R.id.imageView)

        botao.setOnClickListener {
            println("Olá, Android!")
            val intent = Intent(this, ActHome::class.java)
            intent.putExtra("bundle", Bundle().apply {
                putString("chave0", "valor")
                putInt("chave1", 0)
                putFloat("chave2", 0f)
                putDouble("chave3", 0.0)
                putBoolean("chave4", false)
                //etc
            })
            startActivity(intent)
        }
    }

}





































