package com.example.pets

import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    message: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(
        this,
        message,
        duration
    ).show()
}
