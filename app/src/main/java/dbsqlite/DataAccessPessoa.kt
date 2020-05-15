package dbsqlite

import android.content.Context
import android.database.Cursor

private const val ID = "id"
private const val NOME = "nome"
private const val NHE = "sobrenome"
private const val VALIDADE = "idade"

class DataAccessPessoa(
    val context: Context,
    tableName: String,
    tableParams: String,
    version: Int = 1
) : DataAccessSQLite<Pessoa>(context, tableName, tableParams, version) {

    override val cols: Array<String> = arrayOf(ID, NOME, NHE, VALIDADE)

    override fun create(objekt: Pessoa) = insert {
        put(NOME, objekt.nome)
        put(NHE, objekt.sobrenome)
        put(VALIDADE, objekt.idade)
    }

    override fun read(value: Any?, col: String) = mutableListOf<Pessoa>().apply {
        query(
            if (value == null) null else where(col),
            if (value == null) null else arrayOf(value.toString())
        ) {
            while (moveToNext()) {
                add(criaPessoaAPartirDoBanco())
            }
        }
    }

    private fun Cursor.criaPessoaAPartirDoBanco() = Pessoa(
        getInt(0),
        getString(1),
        getString(2),
        getInt(3)
    )// Cursor == objeto que lê item por item do DB

    override fun update(id: Int, objekt: Pessoa) = update(WHERE_ID_IS, id) {
        put(NOME, objekt.nome)
        put(NHE, objekt.sobrenome)
        put(VALIDADE, objekt.idade)
    }

    override fun destroy(id: Int) = delete(WHERE_ID_IS, id)
}