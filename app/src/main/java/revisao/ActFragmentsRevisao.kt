package revisao

import base.ActBind
import com.example.exemplo.databinding.ActFragmentsRevisaoBinding
import custom.carregaFrag
import custom.viewBind

class ActFragmentsRevisao : ActBind<ActFragmentsRevisaoBinding>() {

    override val binding: ActFragmentsRevisaoBinding by viewBind()

    override fun ActFragmentsRevisaoBinding.onBoundView() {

        trocaFragsFusca.setOnClickListener {
            carregaFrag<FragFusca>(addToBackStack = false)
        }

        trocaFragsCamaroMeiaBoca.setOnClickListener {
            carregaFrag<FragCamaroMeiaBoca>(addToBackStack = false)
        }
    }
}