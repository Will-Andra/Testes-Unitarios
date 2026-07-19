package com.example.testeunitario_dummyapi.view.viewmodel

import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.usecase.UsuarioUseCase

class UsuarioUseCaseFake(): UsuarioUseCase {

    override suspend fun invoke(): List<Usuario> {
        return listOf(
            Usuario(25,"Harisson", "Silva"),
            Usuario(32,"Marina", "Monte"),
            Usuario(27,"Afonso", "Luiz"),
            Usuario(33,"Antônio", "Leite")
        )
    }

}