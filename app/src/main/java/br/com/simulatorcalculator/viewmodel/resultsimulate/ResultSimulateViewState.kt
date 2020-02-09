package br.com.simulatorcalculator.viewmodel.resultsimulate

import br.com.simulatorcalculator.model.SimulationResult

open interface ResultSimulateViewState {
    open class onSucess(var simulationResult: SimulationResult?) :
        ResultSimulateViewState
    open class onError(var simulationResult: SimulationResult?) :
        ResultSimulateViewState
}