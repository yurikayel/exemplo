package firebase.database

import androidx.activity.viewModels
import base.ActBind
import com.example.exemplo.databinding.ActFireDatabaseBinding
import custom.viewBind

class ActFireDatabase : ActBind<ActFireDatabaseBinding>() {

    override val binding: ActFireDatabaseBinding by viewBind()
    private val viewModel: ViewModelFireDatabase by viewModels()

}