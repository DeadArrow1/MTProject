package com.example.mtproject.retrofit

import com.example.mtproject.api.CSGOApiService
import com.example.mtproject.model.Patches
import retrofit2.http.GET

interface RetrofitApi : CSGOApiService {

@GET("/CSGO-API/api/en/patches.json")
    override suspend fun getPatches(): Patches
}