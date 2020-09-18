package com.example.myapplication.data

import com.google.gson.annotations.SerializedName


data class UserModel (

    @SerializedName("code") val code : Int,
    @SerializedName("meta") val meta : Meta,
    @SerializedName("data") val data : List<User>
)
