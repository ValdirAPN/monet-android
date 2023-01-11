package com.vpn.monet.domain.common.utils

import java.text.NumberFormat
import java.util.*

fun Double.toCurrency(): String {
    val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault())
    return currencyFormatter.format(this)
}