package br.com.simulatorcalculator.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstanceRetrofit {
    companion object {
        private const val path = "https://api-simulator-calc.easynvest.com.br/calculator/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}