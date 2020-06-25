package dbsqlite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//POKO
//Não confundir com BOJO

@Parcelize
data class Pessoa(
    val id: Int = 0,
    val nome: String,
    val sobrenome: String,
    val idade: Int
) : Parcelable {
    constructor(nome: String, sobrenome: String, idade: Int)
            : this(0, nome, sobrenome, idade)

    companion object {
        @JvmStatic
        fun pessoaVazia() = Pessoa("N/A", "N/A", 0)
    }

}
