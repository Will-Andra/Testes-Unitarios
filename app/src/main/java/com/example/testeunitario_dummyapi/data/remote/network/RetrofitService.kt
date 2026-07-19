package com.example.testeunitario_dummyapi.data.remote.network

import com.example.testeunitario_dummyapi.data.remote.api.DummyAPIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {

    private val retrofitAPIService = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dummyAPI: DummyAPIService by lazy{
        retrofitAPIService.create(DummyAPIService::class.java)
    }
}