package br.com.logan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.logan.model.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_loading.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        btPesquisar.setOnClickListener {
            mainViewModel.pesquisar(inputUsuario.text.toString())
        }

        registerObserver()
    }

    private fun registerObserver() {
        mainViewModel.usuarioResponse.observe(this, Observer {
            setUsuario(it)
        })
        mainViewModel.loading.observe(this, Observer {
            if(it == true)
                showLoading()
            else
                hideLoading()
        })
        mainViewModel.messageError.observe(this, Observer {
            if(it != "")
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun setUsuario(usuario: Usuario?) {
        tvNomeUsuario.text = usuario?.nome

        Picasso.get()
            .load(usuario?.avatarURL)
            .into(ivUsuario)
    }

    private fun showLoading() {
        containerLoading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        containerLoading.visibility = View.GONE
    }
}


