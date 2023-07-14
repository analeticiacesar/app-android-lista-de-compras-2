package com.analeticiacesar.listadecompras.extensions

import android.widget.ImageView
import coil.load
import com.analeticiacesar.listadecompras.R

fun ImageView.loadImage(url: String? = null) {
    load(url) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }
}