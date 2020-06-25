package firebase.database

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

@IgnoreExtraProperties
@Parcelize
data class Apelido(val nome: String, val apelido: String) : Parcelable {

    @Exclude
    fun toMap(): Map<String, Any?> = mapOf(
        "nome" to nome,
        "apelido" to apelido
    )
}