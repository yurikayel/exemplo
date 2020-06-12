package binding

import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActSacheBinding
import custom.viewBind

class ActWhiskas : ActBind<ActSacheBinding>() {

    override val binding: ActSacheBinding by viewBind()

    override fun ActSacheBinding.onBoundView() {
        whiskasText.text = getString(R.string.rafinha)
//        whiskasImage.setImageResource()
    }
}