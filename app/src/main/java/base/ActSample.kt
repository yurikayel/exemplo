package base

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.example.exemplo.databinding.ActSampleBinding

class ActSample : ActBind<ActSampleBinding>(ActSampleBinding::class.java){

    override var viewModel: ViewModel? = null

    override fun Bundle.onExtras() {

    }

    override fun ViewModel.onViewModel() {

    }

    override fun ActSampleBinding.onBoundView() {
        textViewTitulo.text = "whatever"
        textViewSubTitulo.text = "whatever"
        textViewMensagem.text = "whatever"
    }
}