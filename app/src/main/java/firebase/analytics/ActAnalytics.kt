package firebase.analytics

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.exemplo.R
import custom.new
import custom.onClick
import debugging.RafinhaException

class ActAnalytics : AppCompatActivity() {

    val view by lazy { new<LinearLayout>(R.style.LinearVertical) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view)
        view.addView(new<Button> {
            text = context.getString(R.string.rafinha_exception)
            onClick { throw RafinhaException() }
        })
    }

}