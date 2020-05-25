package binding

import base.ActBind
import com.example.exemplo.databinding.ActSacheBinding

class ActWhiskas : ActBind<ActSacheBinding>() {

    override val binding by lazy { bind(ActSacheBinding::class) }

    override fun ActSacheBinding.onBoundView() {
        whiskasText.text = "Rafinha"
//        whiskasImage.setImageResource()
    }
}