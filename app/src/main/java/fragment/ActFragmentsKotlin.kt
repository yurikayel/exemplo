package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.exemplo.R

class ActFragmentsKotlin : AppCompatActivity() {

    lateinit var azul: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        achaViews()
        colocaClick()
    }

    private fun achaViews() {
        setContentView(R.layout.act_fragments)
        azul = findViewById(R.id.button_azul)
    }

    private fun colocaClick() {
        findViewById<Button>(R.id.button_vermelho).carregaFrag(
            FragVermelhoKotlin.newInstance(
                Bundle().apply { putString("verde", "Palmera") }
            )
        )
        azul.carregaFrag(FragAzul.newInstance(Bundle().apply {
            putString("chave", "Azul Caneta Caneta Azul")
        }))
        findViewById<Button>(R.id.button_verde).carregaFrag(
            FragVerde.newInstance(Bundle().apply {
                putString("chave", "Não tem mundial")
            })
        )
    }

    //Função de expressão única
    //Quando a função retorna uma única expressão,
    //as chaves enroladinhas podem ser omitidas e o corpo da função pode ser apontado
    //usando o operador ATRIBUIR (=) "assign"
//    private fun Button.clickBotao(frag: Fragment) = setOnClickListener {
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.framelayout_amarelo, frag)
//            .commit()
//    }

    // Uma função de extensão serve principalmente pra extender o
    // comportamento geralmente de classes base da framework.
    private fun Button.carregaFrag(frag: Fragment) {
        setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framelayout_amarelo, frag)
                .commit()
        }

//        Mema coisa:
//        setOnClickListener(object : View.OnClickListener{
//            override fun onClick(view: View?) {
//                view?.context
//            }
//        })
    }
}

fun somar(x: Int, y: Int): Int = x + y
fun somarSemEspecificar(x: Int, y: Int) = x + y