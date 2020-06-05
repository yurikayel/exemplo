package custom

import android.widget.TextView
import base.ActBind
import com.example.exemplo.R
import com.example.exemplo.databinding.ActCrossMapBinding

class ActCrossMap : ActBind<ActCrossMapBinding>() {

    override val binding: ActCrossMapBinding by viewBind()

    override fun ActCrossMapBinding.onBoundView() {
        val emptyCrossMap = crossMapOf<Float, Double>()
        emptyCrossMap.put(0f, 0.0)

        val alphabet = listOfRange('A'..'Z')
        val map = crossMapOf(listOfRange(0 until alphabet.size - 2), alphabet)

        map.remove(11)
        map.removeKey(22)
        map.removeValue('J')

        map.keys.forEach {
            val texto = "key: ${map.getKey(map.getValue(it)!!)} value: ${map.getValue(it)}"
            crossmapLinear.addView(
                TextView(this@ActCrossMap, null, 0, R.style.AppDialogSubTitle)
                    .apply { text = texto }
            )
        }
    }
}