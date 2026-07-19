package com.example.testeunitario_dummyapi.data.repository

import com.example.testeunitario_dummyapi.data.api.DummyAPIFake
import com.example.testeunitario_dummyapi.data.remote.repository.UsuarioRepositoryImpl
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test


class UsuarioRepositoryImplTest {

    private lateinit var dummyAPIServiceFake: DummyAPIFake

    @Before
    fun setUp() {
        dummyAPIServiceFake = DummyAPIFake()
    }

    @Test
    fun lista_recuperaListagemDeUsuariosAPI_retornaLista() = runTest{

        val usuarioRepository = UsuarioRepositoryImpl(dummyAPIServiceFake)
        val listagem = usuarioRepository.listar()
        assertThat(listagem).isNotEmpty()

    }

    @After
    fun tearDown() {
        //
    }

}