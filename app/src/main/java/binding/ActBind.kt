package binding

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.viewbinding.ViewBinding

@Suppress("UNCHECKED_CAST")
abstract class ActBind<T : ViewBinding>(private val clazz: Class<T>) : AppCompatActivity() {

    lateinit var binding: T

    fun inflate() =
        clazz.getMethod("inflate", LayoutInflater::class.java)
            .invoke(null, layoutInflater) as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate()
        setContentView(binding.root)
        binding.onView()
    }

    abstract fun T.onView()
}


