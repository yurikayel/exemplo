package custom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.example.exemplo.databinding.ActHostItemBinding
import custom.adapter.ItemViewBuilder
import kotlin.reflect.KClass

class ItemViewActivity : ItemViewBuilder<KClass<AppCompatActivity>, ActHostItemBinding>() {

    override val binding by lazy { bind(ActHostItemBinding::class) }

    override fun ActHostItemBinding.onBind(position: Int) {
        val activity = collection.get(position)
        actHostButton.run {
            text = activity.java.name
            setOnClickListener { context.startActivity(Intent(context, activity.java)) }
        }
    }
}