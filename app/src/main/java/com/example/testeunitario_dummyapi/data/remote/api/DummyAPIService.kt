package com.example.testeunitario_dummyapi.data.remote.api

import com.example.testeunitario_dummyapi.data.remote.dto.ResponseDummyApiUser
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPIService {

    //"https://dummyjson.com/"
    @GET("users")
    suspend fun recuperaUsuarios(): Response<ResponseDummyApiUser>

}