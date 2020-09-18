package com.example.myapplication.api

import com.example.myapplication.data.users.UserModel

interface ApiHelper {

    suspend fun getUsers(): UserModel
}