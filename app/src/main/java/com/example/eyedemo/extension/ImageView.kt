package com.example.eyedemo.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.eyedemo.R
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

fun ImageView.load(url: String, round: Float = 0f, cornerType: RoundedCornersTransformation.CornerType = RoundedCornersTransformation.CornerType.ALL) {
    if (round == 0f) {
        Glide.with(this.context).load(url).into(this)
    } else {
        val option = RequestOptions.bitmapTransform(RoundedCornersTransformation(dp2px(round), 0, cornerType)).placeholder(
            R.drawable.shape_album_loading_bg)
        Glide.with(this.context).load(url).apply(option).into(this)
    }
}