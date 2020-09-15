package com.example.myapplication.ui.main.viewstate

import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.Posts

sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class Posts(val posts: ListOfPosts) : MainState()
    data class Error(val error: String?) : MainState()

}