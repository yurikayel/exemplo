package firebase.database

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Apelido(val nome: String, val apelido: String) {

    @Exclude
    fun toMap(): Map<String, Any?> = mapOf(
        "nome" to nome,
        "apelido" to apelido
    )
}