package br.com.simulatorcalculator.view.resultsimulate

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.simulatorcalculator.R
import br.com.simulatorcalculator.util.convertCurrencyLocale
import br.com.simulatorcalculator.util.formatDate
import br.com.simulatorcalculator.util.formatToTwoDecimalPlaces
import br.com.simulatorcalculator.viewmodel.resultsimulate.ResultSimulateViewModel
import br.com.simulatorcalculator.viewmodel.resultsimulate.ResultSimulateViewState
import kotlinx.android.synthetic.main.activity_result_simulate.*

class ResultSimulateActivity : AppCompatActivity() {

    private var dataEntrySimulateViewModel =
        ResultSimulateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_simulate)
        initializeObservable()
        dataEntrySimulateViewModel.requestSimulate()
    }

    private fun initializeObservable(){
        dataEntrySimulateViewModel.viewState.observe(this, Observer {
            when(it){
                is ResultSimulateViewState.onSucess ->{
                    var simulationResult = it.simulationResult
                    tv_result_simulate_all_value.text = "${convertCurrencyLocale(simulationResult!!.grossAmount)}"

                    var alterColorText = SpannableString("${applicationContext.getString(R.string.total_income)} ${convertCurrencyLocale(simulationResult!!.taxesAmount)}")
                    alterColorText.setSpan(ForegroundColorSpan(Color.rgb(8, 242, 110)), applicationContext.getString(R.string.total_income).length, applicationContext.getString(R.string.total_income).length + convertCurrencyLocale(simulationResult!!.taxesAmount).length + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    tv_result_simulate_total_income.setText(alterColorText, TextView.BufferType.SPANNABLE)

                    tv_result_simulate_applied_amount.text = "${convertCurrencyLocale(simulationResult!!.investmentParameter.investedAmount)}"
                    tv_result_simulate_investment_amount.text = "${convertCurrencyLocale(simulationResult!!.grossAmount)}"
                    tv_result_simulate_investment_value.text = "${convertCurrencyLocale(simulationResult!!.grossAmount - simulationResult!!.investmentParameter.investedAmount)}"
                    tv_result_simulate_ir_on_investment.text = "${convertCurrencyLocale(simulationResult!!.taxesAmount)}(${simulationResult!!.taxesRate}%)"
                    tv_result_simulate_net_investment_value.text = "${convertCurrencyLocale(simulationResult!!.netAmount)}"

                    tv_result_simulate_redemption_date.text = "${formatDate(simulationResult!!.investmentParameter.maturityDate)}"
                    tv_result_simulate_running_days.text = "${simulationResult!!.investmentParameter.maturityTotalDays}"
                    tv_result_simulate_monthly_income.text = "${formatToTwoDecimalPlaces("${simulationResult!!.monthlyGrossRateProfit}")}%"
                    tv_result_simulate_investment_cdi_percentage.text = "${formatToTwoDecimalPlaces("${simulationResult!!.investmentParameter.rate}")}%"
                    tv_result_simulate_annual_profitability.text = "${formatToTwoDecimalPlaces("${simulationResult!!.annualNetRateProfit}")}%"
                    tv_result_simulate_profitability_in_the_period.text = "${formatToTwoDecimalPlaces("${simulationResult!!.rateProfit}")}%"
                }
                is ResultSimulateViewState.onError -> {
                    var simulationResult = it.simulationResult
                    tv_result_simulate_all_value.text = simulationResult!!.grossAmount.toString()
                    tv_result_simulate_total_income.text = simulationResult!!.taxesAmount.toString()

                    tv_result_simulate_applied_amount.text = "${applicationContext.getString(R.string.currency)} ${simulationResult!!.investmentParameter.investedAmount}"
                    tv_result_simulate_investment_amount.text = "${applicationContext.getString(R.string.currency)} ${simulationResult!!.grossAmount}"
                    tv_result_simulate_investment_value.text = "${applicationContext.getString(R.string.currency)} ${(simulationResult!!.grossAmount - simulationResult!!.investmentParameter.investedAmount)}"
                    tv_result_simulate_ir_on_investment.text = "${applicationContext.getString(R.string.currency)} ${simulationResult!!.taxesAmount}(${simulationResult!!.taxesRate})"
                    tv_result_simulate_net_investment_value.text = "${applicationContext.getString(R.string.currency)} ${simulationResult!!.netAmount}"

                    tv_result_simulate_redemption_date.text = "${formatDate(simulationResult!!.investmentParameter.maturityDate)}"
                    tv_result_simulate_running_days.text = "${simulationResult!!.investmentParameter.maturityTotalDays}"
                    tv_result_simulate_monthly_income.text = "${formatToTwoDecimalPlaces("${simulationResult!!.monthlyGrossRateProfit}")}%"
                    tv_result_simulate_investment_cdi_percentage.text = "${formatToTwoDecimalPlaces("${simulationResult!!.investmentParameter.rate}")}%"
                    tv_result_simulate_annual_profitability.text = "${formatToTwoDecimalPlaces("${simulationResult!!.annualNetRateProfit}")}%"
                    tv_result_simulate_profitability_in_the_period.text = "${formatToTwoDecimalPlaces("${simulationResult!!.rateProfit}")}%"
                }
            }
        })
    }
}