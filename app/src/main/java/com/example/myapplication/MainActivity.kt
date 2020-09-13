package com.example.myapplication



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.api.RetrofitInstance

import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RetrofitInstance.retrofitInstance?.create()


    }

    }
