package com.example.myapplication.api

import com.example.myapplication.data.users.UserModel

class ApiHelperImpl(private val getService: GetService) : ApiHelper {
    override suspend fun getUsers(): UserModel {
        return getService.getUsers()
    }


}