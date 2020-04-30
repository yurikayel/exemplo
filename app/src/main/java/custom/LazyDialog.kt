package custom

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.appcompat.R
import android.util.TypedValue
import android.widget.Toast
import android.widget.Toast.makeText

fun Context.lazyDialog(title: String, message: String) =
    LazyDialog(this, title, message)

private const val DEFAULT_TEXT = "Whiskas"

class LazyDialog(
    context: Context,
    title: String = DEFAULT_TEXT,
    message: String = DEFAULT_TEXT,
    theme: Int = R.attr.alertDialogTheme
) : AlertDialog.Builder(context, context.resolveAttribute(theme)) {

    var textPositive = "OK!"
    var textNeutral = "Isentão"
    var textNegative = "NO!"

    var onPositive = DialogInterface.OnClickListener { _, _ -> context.toast(textPositive) }
    var onNeutral = DialogInterface.OnClickListener { _, _ -> context.toast(textNeutral) }
    var onNegative = DialogInterface.OnClickListener { _, _ -> context.toast(textNegative) }

    init {
        setTitle(title)
        setMessage(message)
        setPositiveButton(textNegative, onPositive)
        setNeutralButton(textNeutral, onNeutral)
        setNegativeButton(textPositive, onNegative)
    }
}

private fun Context.resolveAttribute(attr: Int) = TypedValue().apply {
    theme.resolveAttribute(attr, this, true)
}.resourceId

private fun Context.toast(message: String) = makeText(this, message, Toast.LENGTH_LONG).show()