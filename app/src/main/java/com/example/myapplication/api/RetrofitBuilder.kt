package com.example.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

  //  private var retrofit:Retrofit? =null
    private const val BASE_URL = "https://gorest.co.in/public-api/"

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiService: ApiService = getRetrofit().create(ApiService::class.java)



}