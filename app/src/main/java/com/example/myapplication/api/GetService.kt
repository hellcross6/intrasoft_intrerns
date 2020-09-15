package com.example.myapplication.api


import com.example.myapplication.data.ListOfPosts
import retrofit2.Call
import retrofit2.http.GET

interface GetService {

    @GET("posts")
    fun getAllPosts() : Call<ListOfPosts>
}