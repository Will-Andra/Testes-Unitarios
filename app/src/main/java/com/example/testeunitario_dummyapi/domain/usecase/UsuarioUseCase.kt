package com.example.testeunitario_dummyapi.domain.usecase

import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.domain.model.Usuario

interface UsuarioUseCase {
    suspend operator fun invoke() : List<Usuario>

}