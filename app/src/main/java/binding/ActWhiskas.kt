package binding

import base.ActBind
import com.example.exemplo.databinding.ActSacheBinding

class ActWhiskas : ActBind<ActSacheBinding>(ActSacheBinding::class.java) {

    override fun ActSacheBinding.onBoundView() {
        whiskasText.text = "Rafinha"
//        whiskasImage.setImageResource()
    }
}