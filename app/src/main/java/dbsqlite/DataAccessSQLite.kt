package dbsqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

abstract class DataAccessSQLite(
    context: Context,
    private val tableName: String,
    tableParams: String,
    version: Int = 1
) {
    abstract val cols: Array<String>

    val banco: SQLiteDatabase by lazy {
        FactoryDataBase(context, tableName, tableParams, version).writableDatabase
    }

    // Extras:

    fun SQLiteDatabase.insert(values: ContentValues.() -> Unit) {
        insert(tableName, null, ContentValues().apply(values))
    }

    fun SQLiteDatabase.query(selection: String? = null, lambda: Cursor.() -> Any) {
        val cursor = banco.query(
            tableName,
            cols,
            selection,
            null,
            null,
            null,
            null
        )
        cursor.lambda()
        cursor.close()
    }

    fun SQLiteDatabase.update(whereClause: String, id: Int, values: ContentValues.() -> Unit) {
        banco.update(tableName, ContentValues().apply(values), whereClause, arrayOf(id.toString()))
    }

    fun SQLiteDatabase.delete(whereClause: String, id: Int) {
        banco.delete(tableName, whereClause, arrayOf(id.toString()))
    }

    companion object {
        const val ID_PKA = "id integer primary key autoincrement"
        const val WHERE_ID_IS = "id = ?"
        const val VIRGULA = ","

        fun string(string: CharSequence, size: Int, end: Boolean = false) =
            "$string varchar ($size)${if (end) "" else ","}"

        fun int(colName: String, end: Boolean = false) = "$colName integer${if (end) "" else ","}"
    }
}
