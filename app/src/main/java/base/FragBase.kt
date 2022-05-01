package base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import custom.IContext

inline fun <reified T : FragBase> new(bundle: Bundle?): T =
    T::class.java.newInstance().apply { arguments = bundle }

abstract class FragBase(val layout : Int = 0) : Fragment(), IContext {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?):
            View? = inflater.inflate(layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.onArguments()
        view.onView()
    }

    open fun Bundle.onArguments() {}

    open fun View.onView() {}
}