package fragment

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

class FragAzul : Fragment() {
    private lateinit var etAzul: EditText
    private lateinit var buttonAzul: Button
    private lateinit var textAzul: TextView
    private lateinit var activity: ActivityContract

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.frag_azul, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActivityContract) activity =
            context
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        etAzul = view.findViewById(R.id.et_azul)
        buttonAzul = view.findViewById(R.id.button_azul)
        textAzul = view.findViewById(R.id.texto_azul)
        buttonAzul.setOnClickListener {
            activity.setTextVermelho(etAzul.text.toString())
        }
    }

    fun setTextAzul(texto: String) {
        textAzul.text = texto
    }

    companion object {
        @JvmStatic fun newInstance(bundle: Bundle? = null): FragAzul {
            val frag = FragAzul()
            frag.arguments = bundle
            return frag
        }
    }
}