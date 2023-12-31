package com.example.mtproject.api

import com.example.mtproject.model.Patches
import retrofit2.http.GET

interface CSGOApiService {

    suspend fun getPatches() : Patches

}