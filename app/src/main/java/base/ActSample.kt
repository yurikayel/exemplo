package base

import android.os.Bundle
import com.example.exemplo.databinding.ActSampleBinding

class ActSample : ActBind<ActSampleBinding>() {

    override val binding: ActSampleBinding by viewBind()

    override fun Bundle.onExtras() {

    }

    override fun ActSampleBinding.onBoundView() {
        textViewTitulo.text = "whatever"
        textViewSubTitulo.text = "whatever"
        textViewMensagem.text = "whatever"
    }
}