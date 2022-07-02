package com.tuyenvo.xeduyen.utils

import android.app.Activity
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat

fun Activity.hideSoftKeyboard() {
    currentFocus?.let {
        val inputMethodManager =
            ContextCompat.getSystemService(this, InputMethodManager::class.java)
        inputMethodManager?.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun <T> Activity.routeToActivity(clazz: Class<T>) {
    Intent(this, clazz).apply {
        addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(this)
        finish()
    }
}

fun <T> Activity.routeToActivityWithStringIntent(clazz: Class<T>, key: String, value: String) {
    Intent(this, clazz).apply {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        putExtra(key, value)
        startActivity(this)
        finish()
    }
}