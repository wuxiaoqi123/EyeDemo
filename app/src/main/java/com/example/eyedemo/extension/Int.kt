package com.example.eyedemo.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.eyedemo.EyepetizerApplication

fun Int.inflate(parent: ViewGroup, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(parent.context).inflate(this, parent, attachToRoot)
}

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(EyepetizerApplication.context, this, duration).show()
}