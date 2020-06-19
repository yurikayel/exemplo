package firebase.database

import androidx.activity.viewModels
import base.ActBind
import com.example.exemplo.databinding.ActFireDatabaseBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import custom.onClick
import custom.string
import custom.toast
import custom.viewBind


class ActFireDatabase : ActBind<ActFireDatabaseBinding>() {

    override val binding: ActFireDatabaseBinding by viewBind()
    private val viewModel: ViewModelFireDatabase by viewModels()

    private val userID get() = FirebaseAuth.getInstance().currentUser?.uid

    override fun ActFireDatabaseBinding.onBoundView() {
        fireDbUpdate.onClick {
            insertUpdate("alcunhas", userID, Apelido(fireDbNome.string, fireDbApelido.string))
            toast("UPDATE\nPARA DE CLICAR!")
        }

        fireDbDelete.onClick {
            delete("alcunhas", userID)
            toast("DELETE\nPARA DE CLICAR!")
        }

        fireDbRead.onClick {
            val apelido = read("alcunhas", userID)
            val stringFormatada = "${apelido?.nome}\n${apelido?.apelido}"
            fireDbOutput.text = stringFormatada
            toast("READ\nPARA DE CLICAR!")
        }
    }

    private fun insertUpdate(dbName: String, id: Any?, objekt: Any) =
        FirebaseDatabase.getInstance().getReference(dbName).child(id.toString()).setValue(objekt)

    private fun delete(dbName: String, id: Any?) =
        FirebaseDatabase.getInstance().getReference(dbName).child(id.toString()).removeValue()

    private fun read(dbName: String, id: Any?): Apelido? {
        var apelido: Apelido? = null

        FirebaseDatabase.getInstance()
                .getReference(dbName)
                .child(id.toString())
                .addValueEventListener(
                    object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            apelido = dataSnapshot.value as Apelido
//                            val map = dataSnapshot.value as Map<*, *>
//                            apelido = Apelido(
//                                map["nome"] as String,
//                                map["apelido"] as String
//                            )
                        }

                        override fun onCancelled(databaseError: DatabaseError) {}
                    }
                )

        return apelido
    }

//    fun test() {
//        val eventListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                dataSnapshot.children.forEach {
//                    for (valor in it.child("alcunha").children) {
//                        val name = valor.getValue(String::class.java)
//                    }
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {}
//        }
//        FirebaseDatabase.getInstance().reference.child("messages")
//                .addListenerForSingleValueEvent(eventListener)
//    }
}