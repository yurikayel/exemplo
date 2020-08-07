package custom

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment
import custom.adapter.ItemViewBuilder

interface IContext {

    val activity
        get() : Activity = when (this) {
            is Fragment              -> requireContext().activity
            is View                  -> context.activity
            is ItemViewBuilder<*, *> -> context.activity
            is Dialog                -> context.activity
            else                     -> this as Activity
        }
}