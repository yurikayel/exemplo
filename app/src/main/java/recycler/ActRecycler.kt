package recycler

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView

class ActRecycler : AppCompatActivity(), OnClickAluno {

    private val recycler by lazy {
        RecyclerView(this)
    }
    private val manager by lazy {
        LinearLayoutManager(this, VERTICAL, false)
    }

    private val alunos = listOf(
        "Rafinha",
        "Henrique",
        "Xandão",
        "Daniel",
        "Peter Henry",
        "Giulia",
        "Felipe"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recycler)

        recycler.layoutManager = manager
        recycler.adapter = AdapterAlunos(this, alunos)
    }

    override fun onClickAluno(position: Int) {
        Toast.makeText(this, alunos[position], LENGTH_LONG).show()
    }
}


