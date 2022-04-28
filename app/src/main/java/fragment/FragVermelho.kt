@file:Suppress("FunctionName")

package fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.exemplo.R

fun Activity.FragVermelho(bundle: Bundle): FragVermelho =
    FragVermelho().also { it.arguments = bundle }

class FragVermelho : Fragment() {

    var activity: ActivityContract? = null

    private lateinit var button: Button
    private lateinit var textVermelho: TextView
    private lateinit var editText: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActivityContract) activity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.frag_vermelho, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editText = view.findViewById(R.id.et_vermelho)
        button = view.findViewById(R.id.button_vermelho)
        textVermelho = view.findViewById(R.id.texto_vermelho)

        button.setOnClickListener {
            activity?.setTextVerde(editText.text.toString())
        }
    }

    fun setTextVermelho(texto: String?) {
        textVermelho.text = texto
    }

}
