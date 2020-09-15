package com.example.myapplication.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Posts (

        @SerializedName("id")
        var id: Int =0,

        @SerializedName("user_id")
        var user_id: Int = 0,

        @SerializedName("title")
        val title: String? = null,

        @SerializedName("body")
        val body: String? = null,

        @SerializedName("created_at")
        val created_at: String? = null,

        @SerializedName("updated_at")
        val updated_at: String? = null
)
