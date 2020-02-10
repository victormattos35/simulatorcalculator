package br.com.simulatorcalculator.view.dataentrysimulate

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.simulatorcalculator.R
import br.com.simulatorcalculator.util.formatDate
import br.com.simulatorcalculator.util.stringDateToDate
import br.com.simulatorcalculator.view.resultsimulate.ResultSimulateActivity
import br.com.simulatorcalculator.viewmodel.dataentrysimulate.validateFieldsEmpty
import kotlinx.android.synthetic.main.activity_data_entry_simulate.*
import java.util.*

class DataEntrySimulateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_entry_simulate)
        setOnClickListener()
        addTextChangedListener()
    }

    private fun addTextChangedListener() {
        ed_data_entry_simulate_value.addTextChangedListener(textWatcher())
        ed_data_entry_simulate_date.addTextChangedListener(textWatcher())
        ed_data_entry_simulate_percentage.addTextChangedListener(textWatcher())
    }

    private fun setOnClickListener() {
        bt_data_entry_simulate_simulate.setOnClickListener {
            Intent(
                this@DataEntrySimulateActivity,
                ResultSimulateActivity::class.java
            ).also { intentResultSimulate ->
                try {
                    intentResultSimulate.putExtra(
                        "investedAmount",
                        ed_data_entry_simulate_value.text
                    )
                    intentResultSimulate.putExtra(
                        "maturityDate",
                        formatDate(
                            stringDateToDate(ed_data_entry_simulate_date.text.toString()),
                            applicationContext.getString(R.string.format_date_eua)
                        )
                    )
                    intentResultSimulate.putExtra("rate", ed_data_entry_simulate_percentage.text)
                    startActivity(intentResultSimulate)
                } catch (error: IllegalArgumentException) {
                    Toast.makeText(
                        this@DataEntrySimulateActivity,
                        applicationContext.getString(R.string.format_date_invalid),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun textWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bt_data_entry_simulate_simulate.isEnabled =
                    validateFieldsEmpty(
                        ed_data_entry_simulate_value.text.toString(),
                        ed_data_entry_simulate_date.text.toString(),
                        ed_data_entry_simulate_percentage.text.toString()
                    )
            }
        }
    }
}