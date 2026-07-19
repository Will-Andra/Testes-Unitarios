package com.example.testeunitario_dummyapi.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.usecase.UsuarioUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(
    private val usuarioUseCase: UsuarioUseCase
) : ViewModel() {

    private val _listaUsuarios = MutableLiveData<List<Usuario>>()
    val listaUsuarios: LiveData<List<Usuario>>
        get() = _listaUsuarios


/*    fun recuperaUsuarios(){
        //Teste antes da API
        val testeDados = listOf(
            Usuario(
                35,
                "William",
                "Gomes"
                )
        )
        _listaUsuarios.postValue(testeDados)
    }*/

    fun recuperaUsuarios(){
        try{
            viewModelScope.launch (Dispatchers.IO){
                println("RASTREIO_API: Iniciando chamada ao UseCase...")
                val listagem = usuarioUseCase()
                println("RASTREIO_API: Sucesso! Recebidos ${listagem.size} usuários.")
                Log.e("REPO_DEBUG", "RecuperarUsuarios VM: ${listagem.hashCode()}")
                _listaUsuarios.postValue(listagem)
            }

        }catch (e: Exception){
            e.printStackTrace()
            println("RASTREIO_API: Erro capturado: ${e.localizedMessage}")
            _listaUsuarios.postValue(emptyList())
        }
    }

}