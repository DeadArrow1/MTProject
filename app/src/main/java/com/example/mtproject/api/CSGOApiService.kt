package com.example.mtproject.api

import com.example.mtproject.domain.SubjectInfoDomain
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StagApiService {

    companion object {
        const val SUBJECT_INFO_ENDPOINT = "/CSGO-API/api/en/patches.json"
    }

    @GET(SUBJECT_INFO_ENDPOINT)
    suspend fun getSubjectInfo (
        @Query("katedra") katedra: String,
        @Query("zkratka") zkratka: String,
        @Query("outputFormat") outputFormat: String = "json"
    ) : Response<SubjectInfoNetwork>
}