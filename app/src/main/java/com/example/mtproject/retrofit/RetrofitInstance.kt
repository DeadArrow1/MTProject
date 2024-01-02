package com.example.mtproject.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val builder: Retrofit = Retrofit.Builder().baseUrl("https://bymykel.github.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RetrofitApi = builder.create(RetrofitApi::class.java)
}