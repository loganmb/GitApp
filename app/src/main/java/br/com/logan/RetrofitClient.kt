package br.com.logan


import br.com.logan.api.GitHubService
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(
        OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build())
    .build()

val gitHubService = retrofit.create(GitHubService::class.java)
