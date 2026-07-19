package com.example.testeunitario_dummyapi.domain.usecase

import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.repository.UsuarioRepository

class UsuarioRepositoryTestFake(): UsuarioRepository {

    override suspend fun listar(): List<Usuario> {
        return listOf(
            Usuario(25,"Harisson", "Silva"),
            Usuario(32,"Marina", "Monte"),
            Usuario(27,"Afonso", "Luiz"),
            Usuario(33,"Antônio", "Leite"),
            Usuario(13,"José", "Santos")
        )
    }
}