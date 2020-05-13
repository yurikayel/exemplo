package data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FactoryDataBase(
    context: Context,
    private val table: String = "semNome",
    private val params: String = "id integer primary key autoincrement," +
            "nome varchar (20)," +
            "sobrenome varchar (20)," +
            "idade integer"
) : SQLiteOpenHelper(context, table, null, 1) {

    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL("create table $table($params)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}