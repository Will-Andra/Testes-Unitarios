package com.example.testeunitario_dummyapi.domain.repository

import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.domain.model.Usuario

interface UsuarioRepository {

    suspend fun listar(): List<Usuario>

}