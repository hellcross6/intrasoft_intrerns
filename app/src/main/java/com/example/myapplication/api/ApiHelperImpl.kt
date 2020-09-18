package com.example.myapplication.api

import com.example.myapplication.data.users.UserModel

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): UserModel {
        return apiService.getUsers()
    }


}