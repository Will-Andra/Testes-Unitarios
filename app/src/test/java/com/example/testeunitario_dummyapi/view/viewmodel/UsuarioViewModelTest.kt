package com.example.testeunitario_dummyapi.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testeunitario_dummyapi.util.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UsuarioViewModelTest {

    private lateinit var usuarioUseCase: UsuarioUseCaseFake

    private lateinit var usuarioViewModel: UsuarioViewModel

    @get:Rule  //Necessário para não quebrar o LiveData, força o LiveData a rodar de forma instantânea e síncrona na mesma thread do teste, evitando o erro de Looper not mocked.
    val instantTaskExecutorRule = InstantTaskExecutorRule() //Classe indicada pelo Google

    @Before
    fun setUp() {
        usuarioUseCase = UsuarioUseCaseFake()
        usuarioViewModel = UsuarioViewModel(usuarioUseCase)
    }

    @Test
    fun recuperarListaUsuarios_validarLiveData_retornarLiveData() = runTest{
        usuarioViewModel.recuperaUsuarios()
        val liveData = usuarioViewModel.listaUsuarios.getOrAwaitValue()
        //getOrAwait vai aguardar ter um valor no listaUsuario para enviar para o liveData.
        assertThat(liveData).isNotEmpty()

    }


    @After
    fun tearDown() {
        //
    }

}