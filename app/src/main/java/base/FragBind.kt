package base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import custom.bindView

abstract class FragBind<T : ViewBinding> : FragBase() {

    abstract val binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.onBoundView()
    }

    abstract fun T.onBoundView()

    inline fun <reified B : ViewBinding> viewBind() =
        lazy { requireContext().bindView(B::class) }
}
