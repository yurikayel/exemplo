package mvvm

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActArquiteturaBinding
import custom.hideKeyBoard
import custom.string
import custom.toast
import custom.viewBind

class ActArquitetura : ActBind<ActArquiteturaBinding>() {

    override val binding: ActArquiteturaBinding by viewBind()
    private val viewModel: ViewModelArquitetura by viewModels()

    override fun ActArquiteturaBinding.onBoundView() {

//        vm.validaDigito("555") tomar cuidado para não tentar chamar Observers
//        ANTES de tê-los configurado

        arqButton.setOnClickListener {
            viewModel.validaDigito(arqInput.string)
            hideKeyBoard()
        }

        viewModel.text.observe(this@ActArquitetura, Observer { retorno -> toast(retorno!!) })

        viewModel.impar.observe(this@ActArquitetura, Observer { ehImpar ->
            arqText.text = getString(if (ehImpar!!) R.string.is_impar else R.string.is_par)
        })
    }
}







