package activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import intent.ActExemplo

class ActCicloDeVida : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, ActExemplo::class.java)
        startActivity(intent)
    }

}