package com.example.testeunitario_dummyapi.data.remote.dto

data class ResponseDummyApiUser(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserDTO>
)