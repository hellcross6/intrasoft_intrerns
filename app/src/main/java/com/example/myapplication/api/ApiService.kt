package com.example.myapplication.api


import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.Posts
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")

    suspend fun getAllPosts() : ListOfPosts
}