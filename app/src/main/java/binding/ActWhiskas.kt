package binding

import base.ActBind
import com.example.exemplo.databinding.ActSacheBinding

class ActWhiskas : ActBind<ActSacheBinding>() {

    override val binding: ActSacheBinding by viewBind()

    override fun ActSacheBinding.onBoundView() {
        whiskasText.text = "Rafinha"
//        whiskasImage.setImageResource()
    }
}