package com.analeticiacesar.listadecompras.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.formatForBrazilianCurrency(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatter.format(this)
}