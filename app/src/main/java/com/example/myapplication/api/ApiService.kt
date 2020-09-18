package com.example.myapplication.api


import com.example.myapplication.data.users.UserModel
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): UserModel
}