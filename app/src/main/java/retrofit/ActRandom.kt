package retrofit

import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActRandomBinding
import custom.AppDialog
import custom.listOfRange
import custom.toast

class ActRandom : ActBind<ActRandomBinding>() {

    override val binding by lazy { bind(ActRandomBinding::class) }
    val list = listOfRange(1..20)

    override fun ActRandomBinding.onBoundView() {
        randomButton.setOnClickListener {
            var textoRandomizado = "Lista Randomizada\nde 1 a 20:\n"
            randomizeIndexes(list.size).forEach { randIndex ->
                textoRandomizado += "\n" + list[randIndex]
            }
            randomText.text = textoRandomizado

            AppDialog(this@ActRandom) {
                title.text = getString(R.string.ricota)
                message.text = getString(R.string.ricota_desc)
                positive.text = getString(R.string.adoro)
                negative.text = getString(R.string.nao_gosto)
                positive.setOnClickListener { toast("SIM!") }
                negative.setOnClickListener { toast("NÃO!") }
            }

        }
    }

    fun randomizeIndexes(sizeArg: Int) = mutableSetOf<Int>().apply {
        while (size < sizeArg) {
            add(random(0, sizeArg - 1))
        }
    }

    fun random(start: Int, end: Int) =
        if (start < end) (start..end).random() else (end..start).random()

}