package functions

import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActReifiedBinding
import custom.new
import custom.onClick
import custom.toast

class ActReified : ActBind<ActReifiedBinding>() {

    override val binding by lazy { bind(ActReifiedBinding::class) }

    val button by lazy { Button(this) }

    override fun ActReifiedBinding.onBoundView() {
        val buttonSlide = new<Button>(R.style.Button) {
            text = "SlideShow"
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_slideshow, 0, 0, 0)
            onClick { toast("SlideShow") }
        }

        val buttonGallery = new<Button>(R.style.Button) {
            text = "Gallery"
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_gallery, 0, 0, 0)
            onClick { toast("Gallery") }
        }

        val buttonCamera = new<Button>(R.style.Button) {
            text = "Camera"
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_camera, 0, 0, 0)
            onClick { toast("Camera") }
        }

        reifiedLinear.addView(buttonSlide)
        reifiedLinear.addView(buttonGallery)
        reifiedLinear.addView(buttonCamera)
    }
}

