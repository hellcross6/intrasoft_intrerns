package com.example.myapplication.ui.main.viewstate
import com.example.myapplication.model.Posts

sealed class MainState {


    object Idle : MainState()
    object Loading : MainState()
    data class Postss(val user: List<Posts>) : MainState()
    data class Error(val error: String?) : MainState()

}