package br.com.simulatorcalculator.repository

import br.com.simulatorcalculator.model.SimulationResult
import retrofit2.Call
import retrofit2.http.GET

interface SimulationResultRequest {

    @GET("simulate")
    fun getSimulation(): Call<SimulationResult>
}