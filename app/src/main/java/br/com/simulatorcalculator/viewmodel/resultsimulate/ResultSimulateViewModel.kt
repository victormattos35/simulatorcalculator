package br.com.simulatorcalculator.viewmodel.resultsimulate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.simulatorcalculator.model.SimulationResult
import br.com.simulatorcalculator.repository.SimulationResultRequest
import br.com.simulatorcalculator.util.InstanceRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultSimulateViewModel : ViewModel() {

    var viewState: MutableLiveData<ResultSimulateViewState> = MutableLiveData()

    val retrofitClient = InstanceRetrofit.getRetrofitInstance()

    fun requestSimulate(investedAmount: String, maturityDate: String, rate: String) {
        val simulationResultRequest = retrofitClient.create(SimulationResultRequest::class.java)
        val simulationRequest =
            simulationResultRequest.getSimulation(investedAmount, "CDI", rate, false, maturityDate)
        simulationRequest.enqueue(object : Callback<SimulationResult> {
            override fun onFailure(call: Call<SimulationResult>, t: Throwable) {
                viewState.postValue(
                    ResultSimulateViewState.onError()
                )
            }

            override fun onResponse(
                call: Call<SimulationResult>,
                response: Response<SimulationResult>
            ) {
                if (response.code() == 500) {
                    viewState.postValue(ResultSimulateViewState.onError())
                } else viewState.postValue(
                    ResultSimulateViewState.onSucess(
                        response.body()
                    )
                )
            }

        })
    }


}