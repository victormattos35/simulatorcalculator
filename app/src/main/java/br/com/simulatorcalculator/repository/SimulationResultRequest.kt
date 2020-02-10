package br.com.simulatorcalculator.repository

import br.com.simulatorcalculator.model.SimulationResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SimulationResultRequest {

    @GET("simulate")
    fun getSimulation(
        @Query("investedAmount") investedAmount: String, @Query("index") index: String, @Query(
            "rate"
        ) rate: String, @Query("isTaxFree") isTaxFree: Boolean, @Query("maturityDate") maturityDate: String
    ): Call<SimulationResult>
}