package com.example.myapplication.api


import com.example.myapplication.data.users.UserModel
import retrofit2.http.GET

interface GetService {

//    @GET("posts")
//    fun getAllPosts() : Call<ListOfPosts>

    @GET("users")
    fun getUsers() : UserModel
}