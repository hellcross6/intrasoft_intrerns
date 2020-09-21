package com.example.myapplication.ui.main.view.Fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.repository.MainRepository
import com.example.myapplication.ui.main.intent.MainIntent
import com.example.myapplication.ui.main.viewstate.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class UserDetailsViewModel(){
//TODO
//    private val repository: MainRepository
//) : ViewModel() {
//
//    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
//    private val _state = MutableStateFlow<MainState>(MainState.Idle)
//    val state: StateFlow<MainState>
//        get() = _state
//
//    init {
//        handleIntent()
//    }
//
//    private fun handleIntent() {
//        viewModelScope.launch {
//            userIntent.consumeAsFlow().collect {
//                when (it) {
//                    is MainIntent.FetchUser -> fetchUser()
//                }
//            }
//        }
//    }
//
//    private fun fetchUser() {
//        viewModelScope.launch {
//            _state.value = MainState.Loading
//            _state.value = try {
//                MainState.GetUsers(repository.getUsers())
//            } catch (e: Exception) {
//                MainState.Error(e.localizedMessage)
//            }
//        }
//    }
}