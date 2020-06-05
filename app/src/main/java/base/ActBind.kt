package base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import custom.adapter.InflateBinding
import custom.bindView

abstract class ActBind<Binding : ViewBinding> : ActBase(), InflateBinding {

    abstract val binding: Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.onBoundView()
    }

    abstract fun Binding.onBoundView()

    inline fun <reified B : ViewBinding> viewBind() = lazy { bindView(B::class) }

}


