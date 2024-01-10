package com.example.mtproject

import android.app.Application
import com.example.mtproject.DB.RoomDB.getDatabase
import com.example.mtproject.api.CSGOApiService
import com.example.mtproject.source.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    val apiService: CSGOApiService by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://bymykel.github.io")
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson for JSON serialization/deserialization
            .build()

        retrofit.create(CSGOApiService::class.java)
    }

    val repository: Repository by lazy {
        Repository(apiService, getDatabase(this))
    }

    override fun onCreate() {
        super.onCreate()
    }
}