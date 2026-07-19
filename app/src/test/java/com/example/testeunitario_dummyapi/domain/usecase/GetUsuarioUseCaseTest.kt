package com.example.testeunitario_dummyapi.domain.usecase

import com.example.testeunitario_dummyapi.data.repository.UsuarioRepositoryImplTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetUsuarioUseCaseTest {

    private lateinit var usuarioRepositoryFake:  UsuarioRepositoryTestFake
    private lateinit var usuarioUseCase: GetUsuarioUseCase


    @Before
    fun setUp() {
        usuarioRepositoryFake = UsuarioRepositoryTestFake()
        usuarioUseCase = GetUsuarioUseCase(usuarioRepositoryFake)
    }

    @Test
    fun invoke_listadeUsuarios_retornaListaFiltrada() = runTest {

        val listaUsuariosFiltrados = usuarioUseCase()
        assertThat(listaUsuariosFiltrados).isNotEmpty()
        assertThat(listaUsuariosFiltrados).hasSize(4)
        assertThat(listaUsuariosFiltrados.map{ it.primeiroNome}).contains("Harisson")

    }



    @After
    fun tearDown() {
        //
    }

}