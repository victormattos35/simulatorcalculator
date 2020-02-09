package br.com.simulatorcalculator.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class InvestmentParameter(
    @SerializedName("investedAmount")
    val investedAmount: Double,
    @SerializedName("yearlyInterestRate")
    val yearlyInterestRate: Double,
    @SerializedName("maturityTotalDays")
    val maturityTotalDays: Int,
    @SerializedName("maturityBusinessDays")
    val maturityBusinessDays: Int,
    @SerializedName("maturityDate")
    val maturityDate: Date,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("isTaxFree")
    val isTaxFree: Boolean
)
