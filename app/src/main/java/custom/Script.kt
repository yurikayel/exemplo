package custom

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Script(var string: String = "") : CharSequence {

    override val length: Int get() = string.length

    override fun get(index: Int) = string[index]

    override fun subSequence(startIndex: Int, endIndex: Int) =
        string.subSequence(startIndex, endIndex)

    override fun toString() = string

    inline fun <reified T> toObjekt(): T =
        Gson().fromJson(string, object : TypeToken<T>() {}.type)
}