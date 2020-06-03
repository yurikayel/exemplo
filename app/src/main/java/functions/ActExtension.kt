package functions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import base.ActBind
import base.ActHost
import com.example.exemplo.databinding.ActExtensionBinding
import kotlin.reflect.KClass

class ActExtension : ActBind<ActExtensionBinding>() {

    val idade: Int = 28
    val nome: String = "Yuri"
    val inicial: Char = 'Y'
    val blocoDeCodigo: () -> Unit = {}
    val invokado: Unit = blocoDeCodigo()

    override val binding: ActExtensionBinding by lazy { bind(ActExtensionBinding::class) }

    override fun ActExtensionBinding.onBoundView() {
        extensionButton.setOnClickListener {
            launchActivityDoRike(ActHost::class) {
                putString("chaves", "henrique")
                putString("kiko", "rafinha")
                putString("chiquinha", "joao")
                this
            }.apply { }
        }
        extensionLinear.addView(Button(this@ActExtension).apply { text = "TrickJaum" })
    }
}

fun <T : Any> Context.launchActivityDoRike(
    clazz: KClass<T>,
    extras: Bundle.() -> Bundle = { this }
) = startActivity(Intent(this, clazz.java).putExtras(Bundle().extras()))

