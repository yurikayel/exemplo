package thread

import base.ActBind
import com.example.exemplo.databinding.ActThreadBinding
import custom.int
import custom.toast

class ActThread : ActBind<ActThreadBinding>(ActThreadBinding::class.java) {

    var run = false

    override fun ActThreadBinding.onBoundView() {
        threadWhiskas.setOnCheckedChangeListener { switch, isChecked ->
            toast(if (isChecked) "whiskas" else "sache")
        }

        threadStart.setOnClickListener {
            run = true
            val numeroInserido = threadInput.int
            Thread(runnable(numeroInserido)).start()
        }

        threadStop.setOnClickListener {
            run = false
        }
    }

    private fun runnable(seconds: Int) = Runnable {
        for (second in 0..seconds) {
            if (run) {
                runOnUiThread { binding.threadStart.text = second.toString() }
                Thread.sleep(1000)
            }
        }
    }
}