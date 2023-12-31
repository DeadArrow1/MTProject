package com.example.mtproject.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val builder = Retrofit.Builder().baseUrl("https://bymykel.github.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = builder.create(RetrofitApi::class.java)
}