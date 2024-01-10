package com.example.mtproject.api

import com.example.mtproject.model.Patches
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CSGOApiService {

    companion object {
        const val PATCHES_ENDPOINT = "/CSGO-API/api/en/patches.json"
    }

    @GET(PATCHES_ENDPOINT)
    suspend fun getPatchesFromAPI () : Response<PatchNetwork>

}