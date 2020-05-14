package dbsqlite

import android.content.Context

private const val ID = "id"
private const val NOME = "nome"
private const val NHE = "sobrenome"
private const val VALIDADE = "idade"

class DataAccessPessoa(
    val context: Context,
    private val tableName: String,
    tableParams: String,
    version: Int = 1
) : DataAccessSQLite(context, tableName, tableParams, version), CRUD<Pessoa> {

    override val cols: Array<String> = arrayOf(ID, NOME, NHE, VALIDADE)

    override fun create(objekt: Pessoa) {
        banco.insert {
            put(NOME, objekt.nome)
            put(NHE, objekt.sobrenome)
            put(VALIDADE, objekt.idade)
        }
    }

    override fun read() = mutableListOf<Pessoa>().apply {
        banco.query {
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
        }
    }

    override fun read(id: Int): Pessoa {
        banco.query(WHERE_ID_IS) {
            while (moveToNext()) {
                return@query Pessoa(
                    getInt(0),
                    getString(1),
                    getString(2),
                    getInt(3)
                )
            }
        }
        return Pessoa.pessoaVazia()
    }

    override fun update(id: Int, pessoa: Pessoa) {
        banco.update(WHERE_ID_IS, id) {
            put(NOME, pessoa.nome)
            put(NHE, pessoa.sobrenome)
            put(VALIDADE, pessoa.idade)
        }
    }

    override fun destroy(id: Int) {
        banco.delete(WHERE_ID_IS, id)
    }

}