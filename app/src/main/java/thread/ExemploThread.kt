package thread

import android.content.Context
import custom.toast

class ExemploThread(val context: Context, private val segundos: Int) : Thread() {
    override fun run() {
        for (segundo in 0 until segundos) {
            context.toast(segundo.toString())
            try {
                sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}