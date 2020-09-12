package com.example.myapplication.api

import com.example.myapplication.model.Posts

class ApiHelperImpl(private val simpleApi: SimpleApi) : ApiHelper {

    override  suspend fun getPosts(): List<Posts>{
        return simpleApi.getPosts()
    }
}