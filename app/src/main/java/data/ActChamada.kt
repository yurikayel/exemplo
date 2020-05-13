package data

import android.content.Context
import android.view.View.OnClickListener
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import base.ActBind
import com.example.exemplo.databinding.ActChamadaBinding
import custom.*

class ActChamada : ActBind<ActChamadaBinding>(ActChamadaBinding::class.java) {

    private val factory by lazy { FactoryDataBase(this, "pessoas") }
    private val access by lazy { AccessPessoa(this, factory) }
    private val pessoas: MutableList<Pessoa> = mutableListOf()

    override fun ActChamadaBinding.onBoundView() {
        chamadaCreate.setOnClickListener(onCreatePessoa())
        chamadaRead.setOnClickListener(onRead())
        chamadaUpdate.setOnClickListener(onUpdate())
        chamadaDestroy.setOnClickListener(onDestroyPessoa())

        pessoas.update(access.read())
        chamadaRecycler.setup<ChamadaViewBuilder>(pessoas)
    }

    private fun ActChamadaBinding.onCreatePessoa() = OnClickListener {
        val pessoa = Pessoa(
            chamadaNome.string,
            chamadaSobrenome.string,
            chamadaIdade.int
        )
        access.create(pessoa)
        pessoa.apply { toast("CREATE\n\n$nome\n$sobrenome\n$idade anos") }
        update()
    }

    private fun ActChamadaBinding.onRead() = OnClickListener {
        if (chamadaId.string.isEmpty()) {
            var nomes = ""
            for (pessoa in access.read()) {
                nomes += pessoa.nome + "\n"
            }
            toast("READ\n\n$nomes")
        } else {
            access.read(chamadaId.int)?.run {
                toast("READ\n\n$nome\n$sobrenome\n$idade anos")
            }
        }
        update()
    }

    private fun onUpdate() = OnClickListener {
        binding.run {
            Pessoa(chamadaNome.string, chamadaSobrenome.string, chamadaIdade.int).run {
                access.update(chamadaId.int, this)
                toast("UPDATE\n\n$nome\n$sobrenome\n$idade anos")
            }
        }
        update()
    }

    private fun ActChamadaBinding.onDestroyPessoa() = OnClickListener {
        access.destroy(chamadaId.int)
        toast("DESTROY\n\nID ${chamadaId.int} destruído")
        update()
    }

    // Abaixo funções auxiliares não mandatórios

    private fun Context.toast(message: String) {
        makeText(this, message, LENGTH_LONG).show()
    }

    private fun update() {
        limpaCampos()
        pessoas.update(access.read())
        binding.chamadaRecycler.update()
        hideSoftKeyBoard()
    }

    private fun limpaCampos() {
        binding.chamadaId.setText("")
        binding.chamadaNome.setText("")
        binding.chamadaSobrenome.setText("")
        binding.chamadaIdade.setText("")
    }

}
