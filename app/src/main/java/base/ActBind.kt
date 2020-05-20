package base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.viewbinding.ViewBinding

abstract class ActBind<T : ViewBinding> : ActBase() {

    abstract val bindClass: Class<T>
    lateinit var binding: T

    val activity by lazy { binding.root.context as AppCompatActivity }

    @Suppress("UNCHECKED_CAST")
    fun inflate() =
        bindClass.getMethod("inflate", LayoutInflater::class.java)
            .invoke(null, layoutInflater) as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate()
        setContentView(binding.root)
        binding.onBoundView()
    }

    abstract fun T.onBoundView()
}


