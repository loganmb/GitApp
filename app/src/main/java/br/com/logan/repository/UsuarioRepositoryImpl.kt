package br.com.logan.repository

import br.com.logan.api.GitHubService
import br.com.logan.model.Usuario
import br.com.logan.repository.UsuarioRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioRepositoryImpl(val service: GitHubService) : UsuarioRepository {
    override fun pesquisar(
        username: String,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        service
            .pesquisar(username)
            .enqueue(object : Callback<Usuario> {
                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if(response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possivel realizar a busca"))
                    }
                }
            })
    }
}

