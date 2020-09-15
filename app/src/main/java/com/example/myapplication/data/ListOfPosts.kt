package com.example.myapplication.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class ListOfPosts (

    @SerializedName("data")
    val data: ArrayList<Posts>

)
