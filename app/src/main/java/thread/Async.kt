package thread

import android.os.AsyncTask

fun doAsync(vararg params: Any = arrayOf(), async: Async<Any, Any, Unit>.() -> Unit)
        : AsyncTask<Any, Any, Unit> = Async(async).execute(params)

open class Async<Params, Progress, Result>(val async: Async<Params, Progress, Result>.() -> Unit) :
    AsyncTask<Params, Progress, Result>() {

    lateinit var preExecute: () -> Unit
    lateinit var onUpdate: () -> Unit
    lateinit var postExecute: () -> Unit

    lateinit var values: Array<out Progress>
    var result: Result? = null

    override fun doInBackground(vararg params: Params?): Result? {
        async()
        return result
    }

    override fun onPreExecute() {
        super.onPreExecute()
        preExecute()
    }

    override fun onProgressUpdate(vararg values: Progress) {
        super.onProgressUpdate(*values)
        this.values = values
        onUpdate()
    }

    override fun onPostExecute(result: Result?) {
        super.onPostExecute(result)
        this.result = result
        postExecute()
    }

    fun preExecute(preExecute: () -> Unit) {
        this.preExecute = preExecute
    }

    fun onUpdate(onUpdate: () -> Unit) {
        this.onUpdate = onUpdate
    }

    fun postExecute(postExecute: () -> Unit) {
        this.postExecute = postExecute
    }
}