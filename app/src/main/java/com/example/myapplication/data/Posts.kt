package com.example.myapplication.data

data class Posts(
    val body: String,
    val created_at: String,
    val id: Int,
    val title: String,
    val updated_at: String,
    val user_id: Int
)