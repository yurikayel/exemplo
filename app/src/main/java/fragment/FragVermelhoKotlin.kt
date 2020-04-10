package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exemplo.R

class FragVermelhoKotlin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.frag_vermelho, container, false)

    companion object {
        fun newInstance(bundle: Bundle) = FragVermelhoKotlin().apply { arguments = bundle }
    }
}