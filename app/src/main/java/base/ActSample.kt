package base

import android.os.Bundle
import com.example.exemplo.R
import com.example.exemplo.databinding.ActSampleBinding
import custom.viewBind

class ActSample : ActBind<ActSampleBinding>() {

    override val binding: ActSampleBinding by viewBind()

    override fun Bundle.onExtras() {

    }

    override fun ActSampleBinding.onBoundView() {
        textViewTitulo.text = getString(R.string.whatever)
        textViewSubTitulo.text = getString(R.string.whatever)
        textViewMensagem.text = getString(R.string.whatever)
    }
}