package br.com.simulatorcalculator.viewmodel.resultsimulate

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResultSimulateViewModelTest {

    lateinit var resultSimulateViewModel: ResultSimulateViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        resultSimulateViewModel = ResultSimulateViewModel()
    }

    @Test
    fun testResultSimulateViewModel() {
        resultSimulateViewModel.requestSimulate("100", "10/10/2020", "100")
    }

}