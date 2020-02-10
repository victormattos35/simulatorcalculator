package br.com.simulatorcalculator.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class SimulationResult(
    @SerializedName("investmentParameter")
    val investmentParameter: InvestmentParameter,
    @SerializedName("grossAmount")
    val grossAmount: Double,
    @SerializedName("taxesAmount")
    val taxesAmount: Double,
    @SerializedName("netAmount")
    val netAmount: Double,
    @SerializedName("grossAmountProfit")
    val grossAmountProfit: Double,
    @SerializedName("netAmountProfit")
    val netAmountProfit: Double,
    @SerializedName("annualGrossRateProfit")
    val annualGrossRateProfit: Double,
    @SerializedName("monthlyGrossRateProfit")
    val monthlyGrossRateProfit: Double,
    @SerializedName("dailyGrossRateProfit")
    val dailyGrossRateProfit: Double,
    @SerializedName("taxesRate")
    val taxesRate: Double,
    @SerializedName("rateProfit")
    val rateProfit: Double,
    @SerializedName("annualNetRateProfit")
    val annualNetRateProfit: Double
) {
    companion object {
        fun simulationMocked(): SimulationResult {
            var investmentParameter =
                InvestmentParameter(32323.0, 9.5512, 1981, 1409, Date(), 123.0, false)
            return SimulationResult(
                investmentParameter,
                60528.20,
                4230.78,
                56297.42,
                28205.20,
                23974.42,
                87.26,
                0.76,
                0.000445330025305748,
                15.0,
                9.5512,
                74.17
            )
        }
    }
}