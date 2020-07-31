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

fun Int.conversionVideoDuration(): String {
    val minute = 1 * 60
    val hour = 60 * minute
    val day = 24 * hour

    return when {
        this < day -> {
            String.format("%02d:%02d", this / minute, this % 60)
        }
        else -> {
            String.format("%02d:%02d:%02d", this / hour, (this % hour) / minute, this % 60)
        }
    }
}