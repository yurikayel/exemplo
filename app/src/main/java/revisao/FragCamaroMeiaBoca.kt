package revisao

import base.FragBase
import com.example.exemplo.R
import custom.ISingleton

class FragCamaroMeiaBoca : FragBase(R.layout.frag_camaro) {

    companion object : ISingleton<FragCamaroMeiaBoca> {
        @JvmStatic
        override val instance by lazy { FragCamaroMeiaBoca() }

        @JvmStatic
        override val name: String by lazy { instance::class.java.name }
    }
}
