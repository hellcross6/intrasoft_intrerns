package com.example.myapplication.repository

import com.example.myapplication.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getPosts() = apiHelper.getAllPosts()

}