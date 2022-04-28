package intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.exemplo.R

class ActExemplo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_exemplo)

        findViewById<View>(R.id.button).setOnClickListener {
            startActivity(
                Intent(this, ActVermelha::class.java)
                    .apply {
                        putExtra(
                            "chavoso",
                            findViewById<EditText>(R.id.edittext).text.toString()
                        )
                        putExtra("nat", "Natalia")
                        putExtra("vit", "Victor")
                        putExtra("gun", "Gunther")
                    }
            )
        }
    }
}