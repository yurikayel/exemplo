package base

import android.os.Bundle
import android.view.LayoutInflater
import android.viewbinding.ViewBinding

abstract class ActBind<T : ViewBinding>(private val clazz: Class<T>)
    : ActBase() {

    lateinit var binding: T

    @Suppress("UNCHECKED_CAST")
    fun inflate() =
        clazz.getMethod("inflate", LayoutInflater::class.java)
            .invoke(null, layoutInflater) as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate()
        setContentView(binding.root)
        binding.onBoundView()
    }

    abstract fun T.onBoundView()
}


