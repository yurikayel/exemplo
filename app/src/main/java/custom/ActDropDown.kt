package custom

import androidx.activity.viewModels
import androidx.core.view.children
import base.ActBind
import com.example.exemplo.databinding.ActDropDownBinding

class ActDropDown : ActBind<ActDropDownBinding>() {

    override val binding: ActDropDownBinding by viewBind()
    private val viewModelLoguinho: ViewModelLoguinho by viewModels()
    private val viewModelFirebase: ViewModelFirebase by viewModels()

    override fun ActDropDownBinding.onBoundView() {
        dropdownButton.onClick {
            dropdownContainer.children.forEach { it.onClick { dropdownContainer.animateExpand(false) } }
            dropdownContainer.animateExpand()
        }
        dropdownPanel.onClick { newPanel(bowserView()) }
    }
}