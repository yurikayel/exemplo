package thread

import base.ActBind
import com.example.exemplo.databinding.ActThreadBinding
import custom.toast

class ActThread : ActBind<ActThreadBinding>(ActThreadBinding::class.java) {

    var stopThread = false

    override fun ActThreadBinding.onBoundView() {
        threadWhiskas.setOnCheckedChangeListener { switch, isChecked ->
            toast(if (isChecked) "whiskas" else "sache")
        }

        threadStart.setOnClickListener { startThread() }
        threadStart.setOnClickListener { stopThread() }
    }

    fun startThread() {
        stopThread = false
        Thread(exampleRunnable(binding.threadInput.toString().toInt())).start()
    }

    fun stopThread() {
        stopThread = true
    }

    private fun exampleRunnable(seconds: Int) = object : Runnable {
        override fun run() {
            for (second in 0 until seconds) {
                if (stopThread) return
                runOnUiThread { binding.threadStart.text = second.toString() }
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
}