package com.example.myapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Posts(
    val body: String,
    val created_at: String,
    val id: Int,
    val title: String,
    val updated_at: String,
    val user_id: Int
) : Parcelable