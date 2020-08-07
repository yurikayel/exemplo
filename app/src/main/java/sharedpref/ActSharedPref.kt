@file:Suppress("HasPlatformType", "MemberVisibilityCanBePrivate")

package sharedpref

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.exemplo.R

class ActSharedPref : AppCompatActivity() {

    val puts by lazy { findViewById<Button>(R.id.puts) }
    val gets by lazy { findViewById<Button>(R.id.gets) }
    val edit by lazy { findViewById<EditText>(R.id.edit) }
    val text by lazy { findViewById<TextView>(R.id.text) }

    private val pref by lazy {
        SharedPref(this, R.string.sharedpref)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_shared_pref)

        puts.setOnClickListener {
            pref.put(R.string.uma_chave, edit.text.toString())
        }

        gets.setOnClickListener {
            text.text = pref.get(R.string.uma_chave)
        }
    }
}


