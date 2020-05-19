package thread

import base.ActBind
import com.example.exemplo.databinding.ActThreadBinding

class ActAsync : ActBind<ActThreadBinding>(ActThreadBinding::class.java) {

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