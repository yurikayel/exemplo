package custom

import androidx.core.view.children
import base.ActBind
import com.example.exemplo.databinding.ActDropDownBinding

class ActDropDown : ActBind<ActDropDownBinding>() {

    override val binding: ActDropDownBinding by viewBind()

    override fun ActDropDownBinding.onBoundView() {
        dropdownButton.onClick {
            dropdownContainer.children.forEach { it.onClick { dropdownContainer.animateExpand(false) } }
            dropdownContainer.animateExpand()
        }
    }
}