package br.com.logan.repository

import br.com.logan.model.Usuario

interface UsuarioRepository {

    fun pesquisar(
        username: String,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    )

}