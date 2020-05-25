package dbsqlite

import android.content.Context
import android.view.View.OnClickListener
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import base.ActBind
import com.example.exemplo.databinding.ActChamadaBinding
import custom.*
import dbsqlite.DataAccessSQLite.Companion.ID_PKA
import dbsqlite.DataAccessSQLite.Companion.int
import dbsqlite.DataAccessSQLite.Companion.string

class ActChamada : ActBind<ActChamadaBinding>() {

    override val binding by lazy { bind(ActChamadaBinding::class) }

    private val tableName = "pessoas"
    private val tableParams = ID_PKA +
            string("nome", 20) +
            string("sobrenome", 20) +
            int("idade", end = true)

    private val dataAccess by lazy {
        DataAccessPessoa(this, tableName, tableParams, 2)
    }

    private val pessoas: MutableList<Pessoa> = mutableListOf()

    override fun ActChamadaBinding.onBoundView() {
        chamadaCreate.setOnClickListener(onCreatePessoa())
        chamadaRead.setOnClickListener(onRead())
        chamadaUpdate.setOnClickListener(onUpdate())
        chamadaDestroy.setOnClickListener(onDestroyPessoa())

        pessoas.update(dataAccess.read())
        chamadaRecycler.setup<ChamadaViewBuilder>(pessoas)
    }

    private fun ActChamadaBinding.onCreatePessoa() = OnClickListener {
        val pessoa = Pessoa(
            chamadaNome.string,
            chamadaSobrenome.string,
            chamadaIdade.int
        )
        dataAccess.create(pessoa)
        pessoa.apply { toast("CREATE\n\n$nome\n$sobrenome\n$idade anos") }
        updateUI()
    }

    private fun ActChamadaBinding.onRead() = OnClickListener {
        if (chamadaId.string.isEmpty()) {
            var nomes = ""
            for (pessoa in dataAccess.read()) {
                nomes += pessoa.nome + "\n"
            }
            toast("READ\n\n$nomes")
        } else {
            dataAccess.read(chamadaId.int)[0].run {
                toast("READ\n\n$nome\n$sobrenome\n$idade anos")
            }
        }
        updateUI()
    }

    private fun onUpdate() = OnClickListener {
        binding.run {
            Pessoa(
                chamadaNome.string,
                chamadaSobrenome.string,
                chamadaIdade.int
            ).run {
                dataAccess.update(chamadaId.int, this)
                toast("UPDATE\n\n$nome\n$sobrenome\n$idade anos")
            }
        }
        updateUI()
    }

    private fun ActChamadaBinding.onDestroyPessoa() = OnClickListener {
        dataAccess.destroy(chamadaId.int)
        toast("DESTROY\n\nID ${chamadaId.int} destruído")
        updateUI()
    }

    // Abaixo funções auxiliares não mandatórios

    private fun Context.toast(message: String) {
        makeText(this, message, LENGTH_LONG).show()
    }

    private fun updateUI() {
        limpaCampos()
        pessoas.update(dataAccess.read())
        binding.chamadaRecycler.update()
        hideKeyBoard()
    }

    private fun limpaCampos() {
        binding.chamadaId.setText("")
        binding.chamadaNome.setText("")
        binding.chamadaSobrenome.setText("")
        binding.chamadaIdade.setText("")
    }

}
