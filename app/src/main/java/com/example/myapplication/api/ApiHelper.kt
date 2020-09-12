package com.example.myapplication.api

import com.example.myapplication.model.Posts

interface ApiHelper {

    suspend fun getPosts(): List<Posts>
}