package br.com.simulatorcalculator.util

import kotlinx.android.synthetic.main.activity_data_entry_simulate.*
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

fun formatDate(date: Date, format: String): String {
    var dateFormat = SimpleDateFormat(format)
    return dateFormat.format(date)
}

fun stringDateToDate(stringDate: String): Date {
    return SimpleDateFormat("dd/MM/yyyy").parse(stringDate)
}
