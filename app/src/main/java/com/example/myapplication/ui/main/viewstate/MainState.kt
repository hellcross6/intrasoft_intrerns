package com.example.myapplication.ui.main.viewstate
import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.UserModel


sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class GetUsers(val user: UserModel) : MainState()
    data class GetPosts(val post :ListOfPosts) :MainState()
    data class Error(val error: String?) : MainState()

}