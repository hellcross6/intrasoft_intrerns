package com.example.myapplication.repository

import com.example.myapplication.api.ApiHelper
import com.example.myapplication.api.RetrofitBuilder
import com.example.myapplication.data.ListOfPosts

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getPosts() = apiHelper.getPosts()

}