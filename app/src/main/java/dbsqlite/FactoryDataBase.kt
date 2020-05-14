package dbsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FactoryDataBase(
    context: Context,
    private val table: String,
    private val params: String,
    private val version: Int = 1
) : SQLiteOpenHelper(context, table, null, version) {

    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL("create table $table($params)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}