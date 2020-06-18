package firebase.database

import androidx.activity.viewModels
import base.ActBind
import com.example.exemplo.databinding.ActFireDatabaseBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import custom.onClick
import custom.string
import custom.viewBind

class ActFireDatabase : ActBind<ActFireDatabaseBinding>() {

    override val binding: ActFireDatabaseBinding by viewBind()
    private val viewModel: ViewModelFireDatabase by viewModels()

    private val caraCracha = FirebaseAuth.getInstance()

    override fun ActFireDatabaseBinding.onBoundView() {
        fireDbUpdate.onClick {
            val input = fireDbApelido.string
            val apelido = NomeDeGuerra(caraCracha.currentUser?.uid ?: input, input)

            val firebaseDB = FirebaseDatabase.getInstance()
            val dbApelidos = firebaseDB.getReference("apelidos")
            val pushKey = dbApelidos.push().key!!

            dbApelidos.child(pushKey).setValue(apelido)
        }
    }
}