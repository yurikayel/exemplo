package mvvm

import android.arch.lifecycle.Observer
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActArquiteturaBinding
import custom.hideKeyBoard
import custom.newViewModel
import custom.string
import custom.toast

class ActArquitetura : ActBind<ActArquiteturaBinding>() {

    override val binding by lazy { bind(ActArquiteturaBinding::class) }
    private val viewModel by lazy { newViewModel<ViewModelArquitetura>() }

    override fun ActArquiteturaBinding.onBoundView() {

//        vm.validaDigito("555") tomar cuidado para não tentar chamar Observers
//        ANTES de tê-los configurado

        arqButton.setOnClickListener {
            viewModel.validaDigito(arqInput.string)
            hideKeyBoard()
        }

        viewModel.text.observe(activity, Observer { retorno -> toast(retorno!!) })

        viewModel.impar.observe(activity, Observer { ehImpar ->
            arqText.text = getString(if (ehImpar!!) R.string.is_impar else R.string.is_par)
        })
    }
}







