package br.com.simulatorcalculator.util

import org.hamcrest.CoreMatchers
import org.junit.Test

import org.junit.Assert.*
import java.util.*

class UtilsKtTest {

    @Test
    fun convertCurrencyLocale() {
        assertThat(convertCurrencyLocale(12.0), CoreMatchers.`is`("R$ 12,00"))
    }

    @Test
    fun formatToTwoDecimalPlaces() {
        assertEquals(formatToTwoDecimalPlaces("12"), "12,00")
    }

    @Test
    fun formatDate() {
        assertEquals(formatDate(Date("10/02/2020"), "yyyy-MM-dd"), "2020-10-02")
    }
}