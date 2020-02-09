package br.com.simulatorcalculator.util

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun convertCurrencyLocale(number: Double): String {
    var formatNumber = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return formatNumber.format(number)
}

fun formatToTwoDecimalPlaces(value: String): String {
    return String.format("%.2f", value.toDouble()).replace(".", ",")
}

fun formatDate(date: Date): String {
    var dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(date)
}