package fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exemplo.R

class FragVermelhoKotlin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.frag_vermelho, container, false)

    companion object {
        fun newInstance(bundle: Bundle) = FragVermelhoKotlin().apply { arguments = bundle }
    }
}