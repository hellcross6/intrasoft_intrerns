package com.example.myapplication.api

import com.example.myapplication.data.ListOfPosts

interface ApiHelper {

    suspend fun getPosts(): ListOfPosts
}