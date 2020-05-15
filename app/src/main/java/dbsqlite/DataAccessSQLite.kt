package dbsqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

abstract class DataAccessSQLite<Type>(
    context: Context,
    private val tableName: String,
    tableParams: String,
    version: Int = 1
) : CRUD<Type> {
    abstract val cols: Array<String>

    private val banco: SQLiteDatabase by lazy {
        FactoryDataBase(context, tableName, tableParams, version).writableDatabase
    }

    fun insert(values: ContentValues.() -> Unit) {
        banco.insert(tableName, null, ContentValues().apply(values))
    }

    fun query(
        selection: String? = null,
        args: Array<String>? = null,
        lambda: Cursor.() -> Any
    ) {
        val cursor = banco.query(
            tableName,
            cols,
            selection,
            args,
            null,
            null,
            null
        )
        cursor.lambda()
        cursor.close()
    }

    fun update(whereClause: String, id: Int, values: ContentValues.() -> Unit) {
        banco.update(tableName, ContentValues().apply(values), whereClause, arrayOf(id.toString()))
    }

    fun delete(whereClause: String, id: Int) {
        banco.delete(tableName, whereClause, arrayOf(id.toString()))
    }

    companion object {
        const val WHERE_ID_IS = "id = ?"
        const val VIRGULA = ","
        const val ID_PKA = "id integer primary key autoincrement$VIRGULA"

        fun where(col: String) = "$col = ?"

        fun string(string: CharSequence, size: Int, end: Boolean = false) =
            "$string varchar ($size)${if (end) "" else ","}"

        fun int(colName: String, end: Boolean = false) = "$colName integer${if (end) "" else ","}"
    }
}
