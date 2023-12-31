package com.example.mtproject

import android.app.Application
import com.example.mtproject.api.StagApiService
import com.example.mtproject.database.getDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyApplication : Application() {
    val apiService: StagApiService by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://bymykel.github.io")
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson for JSON serialization/deserialization
            .build()

        retrofit.create(StagApiService::class.java)
    }

    val repository: Repository by lazy {
        Repository(apiService, getDatabase(this))
    }

    override fun onCreate() {
        super.onCreate()
    }
}