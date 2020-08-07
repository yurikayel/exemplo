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

class FragVerde : Fragment() {

    private lateinit var etVerde: EditText
    private lateinit var buttonVerde: Button
    private lateinit var textVerde: TextView
    private lateinit var activity: ActivityContract

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.frag_verde, container, false)

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
        etVerde = view.findViewById(R.id.et_verde)
        buttonVerde = view.findViewById(R.id.button_verde)
        textVerde = view.findViewById(R.id.texto_verde)
        buttonVerde.setOnClickListener {
            activity.setTextAzul(
                etVerde.text.toString()
            )
        }
    }

    fun setTextVerde(texto: String) {
        textVerde.text = texto
    }

    companion object {
        @JvmStatic fun newInstance(bundle: Bundle? = null): FragVerde {
            val frag = FragVerde()
            frag.arguments = bundle
            return frag
        }
    }
}