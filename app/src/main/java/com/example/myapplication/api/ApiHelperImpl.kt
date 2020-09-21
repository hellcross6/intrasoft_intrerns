package com.example.myapplication.api

import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.UserModel
import retrofit2.Call

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): UserModel {
        return apiService.getUsers()
    }

    override suspend fun getPosts(): ListOfPosts {
        return  apiService.getPosts()
    }


}