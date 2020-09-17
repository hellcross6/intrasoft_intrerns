package com.example.myapplication.api

import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.Posts
import retrofit2.Call

interface ApiHelper {

    suspend fun getAllPosts(): ListOfPosts
}