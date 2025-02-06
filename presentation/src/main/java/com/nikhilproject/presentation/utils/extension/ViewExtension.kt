package com.nikhilproject.presentation.utils.extension

import android.app.Activity
import android.view.View
import android.widget.Toast

object ViewExtension {
    fun View.visibilityToggle(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun Activity.showToast(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}