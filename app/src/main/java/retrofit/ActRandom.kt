package retrofit

import base.ActBind
import com.example.exemplo.databinding.ActRandomBinding
import custom.listOfRange

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
        }
    }

    fun random(start: Int, end: Int) =
        if (start < end) (start..end).random() else (end..start).random()

    fun randomizeIndexes(sizeArg: Int) = mutableListOf<Int>().apply {
        while (size < sizeArg) {
            random(0, sizeArg - 1).let {
                if (!contains(it)) {
                    add(it)
                }
            }
        }
    }
}