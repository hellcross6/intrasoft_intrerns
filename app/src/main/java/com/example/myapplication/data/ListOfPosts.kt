package com.example.myapplication.data

import android.graphics.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class ListOfPosts (

//    @SerializedName("meta")
//    val meta: ArrayList<Meta>,
    @SerializedName("data")
    val data: ArrayList<Posts>
)
