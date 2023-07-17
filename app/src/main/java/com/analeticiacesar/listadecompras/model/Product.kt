package com.analeticiacesar.listadecompras.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
class Product (
    val name: String,
    val description: String,
    val value: BigDecimal,
    val image: String? = null
        ) : Parcelable
