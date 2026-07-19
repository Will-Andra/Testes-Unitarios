package com.example.testeunitario_dummyapi.data.api

import com.example.testeunitario_dummyapi.data.dto.UserDTOTestHelper
import com.example.testeunitario_dummyapi.data.remote.api.DummyAPIService
import com.example.testeunitario_dummyapi.data.remote.dto.ResponseDummyApiUser
import retrofit2.Response

class DummyAPIFake() : DummyAPIService {

    val userDTOHelper = UserDTOTestHelper()

    override suspend fun recuperaUsuarios(): Response<ResponseDummyApiUser> {
        return Response.success(
            ResponseDummyApiUser(
                30,
                10,
                100,
                listOf(
                    userDTOHelper.criarUserDTOFake("Jamiel", "da Costa", 35),
                    userDTOHelper.criarUserDTOFake("Mario", "da Silva", 25),
                    userDTOHelper.criarUserDTOFake("Pedro", "Correia", 20),
                    userDTOHelper.criarUserDTOFake("Junior", "Oliveira", 33),
                    userDTOHelper.criarUserDTOFake("Carlos", "Teixeira", 18)
                )
            )
        )
    }
}