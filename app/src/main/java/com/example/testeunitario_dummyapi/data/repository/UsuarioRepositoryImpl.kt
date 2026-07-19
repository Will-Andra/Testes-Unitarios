package com.example.testeunitario_dummyapi.data.remote.repository

import android.util.Log
import com.example.testeunitario_dummyapi.data.remote.api.DummyAPIService
import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO
import com.example.testeunitario_dummyapi.data.remote.dto.toUsuario
import com.example.testeunitario_dummyapi.domain.model.Usuario
import com.example.testeunitario_dummyapi.domain.repository.UsuarioRepository
import kotlinx.coroutines.delay

class UsuarioRepositoryImpl(
    private val apiDummy: DummyAPIService
) : UsuarioRepository {


    override suspend fun listar(): List<Usuario> {

        return try {

            val respostaUser = apiDummy.recuperaUsuarios()

            if (respostaUser.isSuccessful && respostaUser.body() != null) {
                val listaUsuarios = respostaUser.body()?.users

                if (listaUsuarios != null) {
                    Log.e("ANALISE","SEM ERRO")
                    listaUsuarios.map { it.toUsuario() }
                } else {
                    emptyList()
                }
            } else {

                emptyList()
            }

        } catch (t: Throwable) {
            t.printStackTrace()

            emptyList()
        }
    }
}