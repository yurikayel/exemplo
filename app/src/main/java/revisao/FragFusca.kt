package revisao

import base.FragBase
import com.example.exemplo.R
import custom.ISingleton

class FragFusca : FragBase(R.layout.frag_fusca) {

    companion object : ISingleton<FragFusca> {
        override val instance by lazy { FragFusca() }
        override val name: String by lazy { instance::class.java.name }
    }

}