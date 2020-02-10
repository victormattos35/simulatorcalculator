package br.com.simulatorcalculator.util

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstanceRetrofit {
    companion object {
        private const val path = "https://api-simulator-calc.easynvest.com.br/calculator/"
        private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
    }
}