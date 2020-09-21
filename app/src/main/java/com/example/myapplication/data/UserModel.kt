package com.example.myapplication.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel (

    @SerializedName("code") val code : Int,
    @SerializedName("meta") val meta : Meta,
    @SerializedName("data") val user : List<User>
) : Parcelable
