package com.example.mtproject

import android.util.Log
import com.example.mtproject.api.StagApiService
import com.example.mtproject.api.SubjectInfoNetwork
import com.example.mtproject.api.mapToDatabase
import com.example.mtproject.database.MyRoomDatabase
import com.example.mtproject.database.mapToDomain
import com.example.mtproject.domain.SubjectInfoDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class Repository (
    private val apiService: StagApiService,
    private val database: MyRoomDatabase
) {

    suspend fun getSubjectInfo (katedra: String, zkratka: String) : Flow<SubjectInfoDomain> {
        // get data from REST API and cache them to DB
        refreshSubjects(katedra, zkratka)

        // return FLOW of SubjectInfoDomain from database to ViewModel
        return database.subjectInfoDao.getSubjectByZkratka(zkratka)
            .map { it.mapToDomain() }
    }

    suspend fun refreshSubjects(katedra: String, zkratka: String) {
        try {
            // call REST API service to response
            val apiResponse = apiService.getSubjectInfo(katedra, zkratka)
            // parse SubjectInfoNetwork from response body
            val subjectInfoNetwork: SubjectInfoNetwork? = apiResponse.body()

            if(subjectInfoNetwork != null) {
                // convert network model from REST API to DB entity
                val subjectInfoDTO = subjectInfoNetwork.mapToDatabase()

                // save to Room database
                withContext(Dispatchers.IO) {
                    database.subjectInfoDao.insert(subjectInfoDTO)
                }
            } else {
                // no data found on REST API
                Log.v("MYAPP", "Not found on REST API")
            }
        } catch (e: Exception) {
            // Handle PI call errors
            Log.e("MYAPP", "Error refreshing subjects " + e.localizedMessage)
        }
    }
}