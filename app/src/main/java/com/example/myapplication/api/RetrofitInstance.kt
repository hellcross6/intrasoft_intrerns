package com.example.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit:Retrofit? =null
    private var BASE_URL = "https://gorest.co.in/public-api/"


    val retrofitInstance: Retrofit?
    get() {
        if(retrofit == null){
            retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}