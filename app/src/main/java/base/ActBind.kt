package base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.viewbinding.ViewBinding
import custom.adapter.InflateBinding

abstract class ActBind<T : ViewBinding> : ActBase(), InflateBinding {

    abstract val binding: T

    val activity by lazy { binding.root.context as AppCompatActivity }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.onBoundView()
    }

    abstract fun T.onBoundView()
}


