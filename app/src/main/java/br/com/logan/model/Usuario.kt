package br.com.logan.model

import com.google.gson.annotations.SerializedName

data class Usuario(

    @SerializedName("name") val name: String = "",
    @SerializedName("avatar_url") val avatarURL: String
    )
