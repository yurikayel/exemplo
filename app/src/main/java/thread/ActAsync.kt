package thread

import base.ActBind
import com.example.exemplo.databinding.ActThreadBinding

class ActAsync : ActBind<ActThreadBinding>() {

    override val binding: ActThreadBinding by viewBind()

    //TODO PENDENTE DE TESTES

    override fun ActThreadBinding.onBoundView() {
        doAsync {

            preExecute {

            }

            onUpdate {

            }

            postExecute {

            }
        }
    }
}