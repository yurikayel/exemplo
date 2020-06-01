package base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import custom.adapter.InflateBinding

abstract class ActBind<Binding : ViewBinding> : ActBase(), InflateBinding {

    abstract val binding: Binding

    val activity by lazy { binding.root.context as AppCompatActivity }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.onBoundView()
    }

    abstract fun Binding.onBoundView()
}


