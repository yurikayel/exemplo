package recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exemplo.R
import revisao.ActRevisaoFrags

class AdapterAlunos(val context: Context, private val listaDeAlunos: List<String>) :
    RecyclerView.Adapter<AlunoViewHolder>() {

    override fun onCreateViewHolder(group: ViewGroup, type: Int): AlunoViewHolder {
        return AlunoViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.texto_pequeno, group, false)
        )
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val nomeDoAluno = listaDeAlunos[position]
        holder.textView.text = nomeDoAluno
        holder.textView.setOnClickListener {
            (context as OnClickAluno).onClickAluno(position)
            context.startActivity(
                Intent(context, ActRevisaoFrags::class.java)
                    .putExtra("nome", nomeDoAluno)
            )
        }
    }

    override fun getItemCount() = listaDeAlunos.size
}

interface OnClickAluno {
    fun onClickAluno(position: Int)
}


