package com.example.eyedemo.extension

import android.content.Context
import android.content.SharedPreferences
import com.example.eyedemo.EyepetizerApplication
import com.example.eyedemo.util.GlobalUtil

val sharedPreferences: SharedPreferences = EyepetizerApplication.context.getSharedPreferences(
    GlobalUtil.appPackage + "_preferences",
    Context.MODE_PRIVATE
)