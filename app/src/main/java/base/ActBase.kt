package base

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import debugging.ExceptionHandler

const val teste = "teste"

open class ActBase(val layout: Any? = null) : AppCompatActivity() {

    companion object {
        const val teste = "string"

        @JvmStatic lateinit var currentActivity: AppCompatActivity
        @JvmStatic var exceptionHandler = ExceptionHandler()
    }

    open var viewModel: ViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
        when (layout) {
            is Int -> setContentView(layout)
            is View -> setContentView(layout)
        }
        intent?.extras?.onExtras()
        viewModel?.onViewModel()
        onView()
    }

    override fun onResume() {
        super.onResume()
        currentActivity = this
    }

    open fun Bundle.onExtras() {}

    open fun ViewModel.onViewModel() {}

    open fun onView() {}

}