package com.example.myapplication.api

import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.Posts
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {


    override suspend fun getAllPosts() : ListOfPosts {
        return apiService.getAllPosts()
    }
}