package br.com.simulatorcalculator.viewmodel.dataentrysimulate

class DataEntrySimulateViewModel {

    fun validateFieldsEmpty(value : String, date: String, percentage: String) : Boolean{
        return !(value.isEmpty() || date.isEmpty() || percentage.isEmpty())
    }
}