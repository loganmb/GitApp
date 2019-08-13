package br.com.logan.api

import br.com.logan.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{username}")
    fun pesquisar(@Path("username") username: String) : Call<Usuario>

}