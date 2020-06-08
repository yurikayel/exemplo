package dbroomkt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contato")
data class Contato(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "first_name")
    var nome: String,

    @ColumnInfo(name = "last_name")
    var sobrenome: String,

    @ColumnInfo
    var idade: Int
)