package data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper

class AccessPessoa(val context: Context, factory: SQLiteOpenHelper) : CRUD<Pessoa> {

    private val banco = factory.writableDatabase

    override fun create(objekt: Pessoa) {
        val values = ContentValues().apply {
            put("nome", objekt.nome)
            put("sobrenome", objekt.sobrenome)
            put("idade", objekt.idade)
        }
        banco.insert("pessoas", null, values)
    }

    override fun read() = mutableListOf<Pessoa>().apply {
        val cursor = banco.query(
            "pessoas",
            arrayOf("id", "nome", "sobrenome", "idade"),
            null,
            null,
            null,
            null,
            null
        )

        cursor.run {
            while (moveToNext()) {
                add(
                    Pessoa(
                        getInt(0),
                        getString(1),
                        getString(2),
                        getInt(3)
                    )
                )
            }
            close()
        }
    }

    override fun read(id: Int): Pessoa? {
        val cursor = banco.query(
            "pessoas",
            arrayOf("id", "nome", "sobrenome", "idade"),
            "id = ?$id",
            null,
            null,
            null,
            null
        )

        var pessoa: Pessoa? = null

        cursor.run {
            while (moveToNext()) {
                pessoa = Pessoa(
                    getInt(0),
                    getString(1),
                    getString(2),
                    getInt(3)
                )
            }
            close()
        }

        return pessoa
    }

    override fun update(id: Int, objekt: Pessoa) = objekt.apply {
        val values = ContentValues().apply {
            put("nome", nome)
            put("sobrenome", sobrenome)
            put("idade", idade)
        }
        banco.update("pessoas", values, "id = ?", arrayOf(id.toString()))
    }

    override fun destroy(id: Int) {
        banco.delete("pessoas", "id = ?", arrayOf(id.toString()))
    }

}