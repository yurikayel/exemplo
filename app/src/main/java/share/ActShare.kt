package share

import android.content.Intent
import android.content.Intent.*
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActShareBinding
import custom.onClick
import custom.string
import custom.viewBind

class ActShare : ActBind<ActShareBinding>() {
    override val binding: ActShareBinding by viewBind()

    override fun ActShareBinding.onBoundView() {
        val stringLonga =
            getString(R.string.lorem_ipsum) + getString(R.string.pellentesque)

        shareShare.onClick {
            startActivity(
                createChooser(
                    Intent().apply {
                        action = ACTION_SEND
                        type = "text/plain"
                        putExtra(EXTRA_TEXT, "${shareText.string} $stringLonga")
                    }, "Texto do Menuzinho Bacana"
                )
            )
        }

        shareView.onClick {
            startActivity(
                createChooser(
                    Intent().apply {
                        action = ACTION_SEND
                        type = "text/plain"
                        putExtra(EXTRA_TEXT, "${shareText.string} $stringLonga")
                    }, "Texto do Menuzinho Bacana"
                )
            )
        }
    }

}