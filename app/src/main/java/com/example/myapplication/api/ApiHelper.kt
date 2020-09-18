package com.example.myapplication.api

import com.example.myapplication.data.UserModel

interface ApiHelper {
    suspend fun getUsers(): UserModel
}