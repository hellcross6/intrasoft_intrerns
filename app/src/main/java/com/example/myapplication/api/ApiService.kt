package com.example.myapplication.api


import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

//    @GET("posts")
//    fun getAllPosts() : Call<ListOfPosts>

    @GET("users")
     suspend fun getUsers() : UserModel

    @GET ("posts")
    suspend fun getPosts() :ListOfPosts

}