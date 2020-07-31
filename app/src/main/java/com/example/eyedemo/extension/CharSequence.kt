package com.example.eyedemo.extension

import android.widget.Toast
import com.example.eyedemo.EyepetizerApplication

fun CharSequence.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(EyepetizerApplication.context, this, duration).show()
}