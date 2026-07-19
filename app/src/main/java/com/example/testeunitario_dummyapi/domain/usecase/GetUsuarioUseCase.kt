package com.example.testeunitario_dummyapi.domain.usecase

import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.usecase.UsuarioUseCase
import com.example.testeunitario_dummyapi.domain.repository.UsuarioRepository

class GetUsuarioUseCase(
    private val usuarioRepository: UsuarioRepository
) : UsuarioUseCase {

    override suspend fun invoke(): List<Usuario> {
        val listaUsuarios = usuarioRepository.listar()
        return listaUsuarios.filter {it.idade >= 20}
    }
}