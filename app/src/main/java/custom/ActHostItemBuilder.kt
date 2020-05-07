package custom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.example.exemplo.databinding.ActHostItemBinding
import custom.adapter.RecyclerViewBuilder
import kotlin.reflect.KClass

class ActHostItemBuilder : RecyclerViewBuilder<KClass<AppCompatActivity>, ActHostItemBinding>() {

    override val bindClass = ActHostItemBinding::class.java

    override fun ActHostItemBinding.onBind(position: Int) {
        val activity = collection.get(position)
        actHostButton.run {
            text = activity.java.name
            setOnClickListener { context.startActivity(Intent(context, activity.java)) }
        }
    }
}