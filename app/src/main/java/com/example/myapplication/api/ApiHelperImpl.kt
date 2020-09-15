package com.example.myapplication.api

import com.example.myapplication.data.ListOfPosts


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {


    override suspend fun getPosts(): ListOfPosts {
        return apiService.getAllPosts()
    }
}