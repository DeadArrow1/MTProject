package com.example.mtproject.source

import android.util.Log
import com.example.mtproject.DB.RoomDB.MyRoomDatabase
import com.example.mtproject.Domain.PatchDomain
import com.example.mtproject.api.CSGOApiService
import com.example.mtproject.api.PatchNetwork
import com.example.mtproject.api.mapToDatabase
import com.example.mtproject.DB.RoomDB.mapToDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class Repository(private val CSGOApiService: CSGOApiService,private val database: MyRoomDatabase) {


    suspend fun getPatchesFromRepository () : Flow<PatchDomain> {
        // get data from REST API and cache them to DB
        refreshPatchesInformation()

        // return FLOW of SubjectInfoDomain from database to ViewModel
        return database.patchDao.getPatchesFromDatabase()
            .map { it.mapToDomain() }

    }


    private suspend fun refreshPatchesInformation() {
        try {
            // call REST API service to response
            val apiResponse = CSGOApiService.getPatchesFromAPI()
            // parse SubjectInfoNetwork from response body
            val patchInfoNetwork: PatchNetwork? = apiResponse.body()

            if(patchInfoNetwork != null) {
                // convert network model from REST API to DB entity
                for ((i, item) in patchInfoNetwork.withIndex()) {
                    val patchDTO = item.mapToDatabase()
                    // save to Room database
                    withContext(Dispatchers.IO) {
                        database.patchDao.insert(patchDTO)
                    }
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

