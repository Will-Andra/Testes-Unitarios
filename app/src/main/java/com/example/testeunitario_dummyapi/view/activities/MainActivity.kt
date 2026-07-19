package com.example.testeunitario_dummyapi.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testeunitario_dummyapi.data.remote.network.RetrofitService
import com.example.testeunitario_dummyapi.data.remote.repository.UsuarioRepositoryImpl
import com.example.testeunitario_dummyapi.databinding.ActivityMainBinding
import com.example.testeunitario_dummyapi.domain.usecase.GetUsuarioUseCase
import com.example.testeunitario_dummyapi.view.viewmodel.UsuarioViewModel
import com.example.testeunitario_dummyapi.view.viewmodel.UsuarioViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        inicializar()
    }

    private fun inicializar(){
        configurarViewModel()
        observarCamadaViewModel()
    }

    private fun configurarViewModel() {
        val dummyAPI = RetrofitService.dummyAPI
        val userRepository = UsuarioRepositoryImpl(dummyAPI)
        val usuarioUseCase = GetUsuarioUseCase(userRepository)
        usuarioViewModel = ViewModelProvider(
            this, UsuarioViewModelFactory(usuarioUseCase)
        )[UsuarioViewModel::class.java]
    }

    private fun observarCamadaViewModel() {

        usuarioViewModel.listaUsuarios.observe(this){ listaUsuarios ->

            var dadosUsuarios = ""
            listaUsuarios.forEach { usuario ->
                dadosUsuarios += "+ ${usuario.primeiroNome} ${usuario.ultimoNome} (${usuario.idade})\n"
                dadosUsuarios += "\n"
            }
            binding.textConteudo.text = dadosUsuarios
        }
    }

    override fun onStart() {
        super.onStart()
        usuarioViewModel.recuperaUsuarios()
    }

}