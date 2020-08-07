package sharedpref

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import com.example.exemplo.R

class SharedPref(
    val activity: Activity,
    prefFile: Int = R.string.sharedpref
) {

    val sharedPref: SharedPreferences = activity.getSharedPreferences(
        activity.getString(prefFile), MODE_PRIVATE
    )

    inline fun <reified T> get(key: Int): T =
        sharedPref.run {
            val k = activity.getString(key)
            when (T::class) {
                Boolean::class -> getBoolean(k, false) as T
                Float::class   -> getFloat(k, 0f) as T
                Int::class     -> getInt(k, 0) as T
                Long::class    -> getLong(k, 0) as T
                String::class  -> getString(k, "") as T
                else           -> getStringSet(k, setOf("")) as T
            }
        }

    fun <T> put(key: Int, value: T) =
        sharedPref.edit().run {
            val k = activity.getString(key)
            @Suppress("UNCHECKED_CAST")
            when (value) {
                is Boolean -> putBoolean(k, value)
                is Float   -> putFloat(k, value)
                is Int     -> putInt(k, value)
                is Long    -> putLong(k, value)
                is String  -> putString(k, value)
                else       -> putStringSet(k, value as Set<String>)
            }
            apply()
        }

}