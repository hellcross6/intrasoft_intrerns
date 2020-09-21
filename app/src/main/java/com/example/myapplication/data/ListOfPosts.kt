package com.example.myapplication.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.ArrayList

@Parcelize
data class ListOfPosts (


    @SerializedName("data")
    val data: List<Posts>
) : Parcelable