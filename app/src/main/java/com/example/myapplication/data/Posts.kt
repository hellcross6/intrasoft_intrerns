package com.example.myapplication.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Posts (


        var id: Int =0,


        var user_id: Int = 0,


        val title: String? = null,


        val body: String? = null,


        val created_at: String? = null,


        val updated_at: String? = null
)
