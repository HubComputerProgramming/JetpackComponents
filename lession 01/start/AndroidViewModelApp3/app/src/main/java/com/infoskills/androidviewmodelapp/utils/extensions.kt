package com.infoskills.androidviewmodelapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.doGlide(profileImg: String) {
    Glide.with(this)
        .load(profileImg)
        .into(this)
}