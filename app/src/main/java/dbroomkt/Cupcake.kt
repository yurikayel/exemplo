package dbroomkt

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "bolinho")
data class Cupcake(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "first_name")
    var nome: String,

    @ColumnInfo(name = "last_name")
    var sobrenome: String,

    @ColumnInfo
    var idade: Int
)