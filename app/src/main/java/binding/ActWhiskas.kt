package binding

import com.example.exemplo.R
import com.example.exemplo.databinding.ActWhiskasBinding

class ActWhiskas : ActBind<ActWhiskasBinding>(ActWhiskasBinding::class.java) {

    var switchA = false
    var switchB = false

    override fun ActWhiskasBinding.onView() {
        whiskasText.setOnClickListener {
            whiskasText.text = getString(if (switchA) R.string.app_name else R.string.whiskas_sache)
            switchA = !switchA
        }
        whiskasImage.setOnClickListener {
            whiskasImage.setImageResource(if (switchB) R.drawable.whiskas else R.drawable.whiskas_sache)
            switchB = !switchB
        }
    }

}