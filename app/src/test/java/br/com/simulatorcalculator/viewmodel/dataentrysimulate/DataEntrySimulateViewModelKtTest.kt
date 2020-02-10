package br.com.simulatorcalculator.viewmodel.dataentrysimulate

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DataEntrySimulateViewModelKtTest {

    @Test
    fun validateFieldsEmptyTrue() {
        assertTrue(validateFieldsEmpty("Teste1", "Teste2", "Teste3"))
    }

    @Test
    fun validateFieldsEmptyFalse() {
        assertFalse(validateFieldsEmpty("", "Teste3", "Test2"))
    }
}