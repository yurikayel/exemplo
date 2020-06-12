package telainicial

import android.content.Intent
import android.os.Bundle
import base.ActBase
import base.ActHost

class ActSplash : ActBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Thread.setDefaultUncaughtExceptionHandler(ExceptionHandler())
        startActivity(Intent(this, ActHost::class.java))
        finish()
    }
}