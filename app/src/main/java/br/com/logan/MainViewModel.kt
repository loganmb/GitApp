package br.com.logan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.logan.model.Usuario
import br.com.logan.repository.UsuarioRepository


class MainViewModel : ViewModel() {
    var usuarioRepository: UsuarioRepository =
        UsuarioRepositoryImpl(gitHubService)

    val usuarioResponse = MutableLiveData<Usuario>()
    val loading = MutableLiveData<Boolean>()
    val messageError = MutableLiveData<String>()

    fun pesquisar(username: String) {
        loading.value = true
        usuarioRepository.pesquisar(username,
            onComplete = {
                usuarioResponse.value = it
                messageError.value = ""
                loading.value = false
            },
            onError = {
                messageError.value = it?.message
                loading.value = false
            })
    }
}
