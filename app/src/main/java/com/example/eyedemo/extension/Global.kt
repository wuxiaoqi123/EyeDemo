package com.example.eyedemo.extension

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import com.example.eyedemo.EyepetizerApplication
import com.example.eyedemo.util.GlobalUtil

val sharedPreferences: SharedPreferences = EyepetizerApplication.context.getSharedPreferences(
    GlobalUtil.appPackage + "_preferences",
    Context.MODE_PRIVATE
)

fun setOnClickListener(vararg v: View?, block: View.() -> Unit) {
    val listener = View.OnClickListener { it.block() }
    v.forEach { it?.setOnClickListener(listener) }
}