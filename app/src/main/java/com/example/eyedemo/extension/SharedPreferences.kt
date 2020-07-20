package com.example.eyedemo.extension

import android.content.SharedPreferences

fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    action(editor)
    editor.apply()
}