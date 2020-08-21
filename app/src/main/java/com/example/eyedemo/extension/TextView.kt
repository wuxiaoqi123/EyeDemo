package com.example.eyedemo.extension

import android.graphics.drawable.Drawable
import android.widget.TextView

fun TextView.setDrawable(drawable: Drawable?, iconWidth: Float? = null, iconHeight: Float? = null, direction: Int = 0) {
    if (iconWidth != null && iconHeight != null) {
        //第一个0是距左边距离，第二个0是距上边距离，iconWidth、iconHeight 分别是长宽
        drawable?.setBounds(0, 0, dp2px(iconWidth), dp2px(iconHeight))
    }
    when (direction) {
        0 -> setCompoundDrawables(drawable, null, null, null)
        1 -> setCompoundDrawables(null, drawable, null, null)
        2 -> setCompoundDrawables(null, null, drawable, null)
        3 -> setCompoundDrawables(null, null, null, drawable)
        else -> throw NoSuchMethodError()
    }
}