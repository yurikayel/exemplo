package intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.exemplo.R

class ActVermelha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_vermelha)
        intent.extras?.run {
            getString("chavoso")?.let {
                findViewById<TextView>(R.id.texticulo_0).text = it
            }
            getString("nat")?.let {
                findViewById<TextView>(R.id.texticulo_1).text = it
            }
            getString("vit")?.let {
                findViewById<TextView>(R.id.texticulo_2).text = it
            }
            getString("gun")?.let {
                findViewById<TextView>(R.id.texticulo_3).text = it
            }
        }
    }
}