package dbroomkt

import android.content.Context
import android.view.View.OnClickListener
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import base.ActBind
import com.example.exemplo.databinding.ActChamadaBinding
import custom.*

class ActChamadaRoom : ActBind<ActChamadaBinding>(ActChamadaBinding::class.java) {

    private val accessUsuario by lazy {
        DatabaseBuilder.getAppDatabase(this).accessUsuario()
    }

    private val usuarios: MutableList<Usuario> = mutableListOf()

    override fun ActChamadaBinding.onBoundView() {
        chamadaCreate.setOnClickListener(onCreateUsuario())
        chamadaRead.setOnClickListener(onRead())
        chamadaUpdate.setOnClickListener(onUpdate())
        chamadaDestroy.setOnClickListener(onDestroyUsuario())

        usuarios.update(accessUsuario.puxaTodaLista())
        chamadaRecycler.setup<UsuariosViewBuilder>(usuarios)
    }

    private fun ActChamadaBinding.onCreateUsuario() = OnClickListener {
        val pessoa = Usuario(
            0,
            chamadaNome.string,
            chamadaSobrenome.string,
            chamadaIdade.int
        )
        accessUsuario.inserir(pessoa)
        pessoa.apply { toast("CREATE\n\n$nome\n$sobrenome\n$idade anos") }
        updateUI()
    }

    private fun ActChamadaBinding.onRead() = OnClickListener {
        if (chamadaId.string.isEmpty()) {
            var nomes = ""
            for (pessoa in accessUsuario.puxaTodaLista()) {
                nomes += pessoa.nome + "\n"
            }
            toast("READ\n\n$nomes")
        } else {
            accessUsuario.encontrarPorId(chamadaId.int).run {
                toast("READ\n\n$nome\n$sobrenome\n$idade anos")
            }
        }
        updateUI()
    }

    private fun onUpdate() = OnClickListener {
        binding.run {
            Usuario(
                chamadaId.int,
                chamadaNome.string,
                chamadaSobrenome.string,
                chamadaIdade.int
            ).run {
                accessUsuario.atualizar(this)
                toast("UPDATE\n\n$nome\n$sobrenome\n$idade anos")
            }
        }
        updateUI()
    }

    private fun ActChamadaBinding.onDestroyUsuario() = OnClickListener {
        accessUsuario.deletar(Usuario(chamadaId.int, "", "", 0))
        toast("DESTROY\n\nID ${chamadaId.int} destruído")
        updateUI()
    }

    // Abaixo funções auxiliares não mandatórios

    private fun Context.toast(message: String) {
        makeText(this, message, LENGTH_LONG).show()
    }

    private fun updateUI() {
        limpaCampos()
        usuarios.update(accessUsuario.puxaTodaLista())
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
