package com.example.myapplication



import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.api.GetService
import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.data.ListOfPosts

import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val service = RetrofitInstance.retrofitInstance?.create(GetService::class.java)
        val call = service?.getAllPosts()
        call?.enqueue(object : Callback<ListOfPosts> {
            override fun onResponse(call: Call<ListOfPosts>, response: Response<ListOfPosts>) {
                val body = response?.body()
                val data = body?.data
                var size = data?.size


            }

            override fun onFailure(call: Call<ListOfPosts>, t: Throwable) =
                Toast.makeText(applicationContext,"Error json",Toast.LENGTH_LONG).show()
        })

    }

    }
