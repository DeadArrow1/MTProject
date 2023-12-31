package com.example.mtproject.source

import com.example.mtproject.api.CSGOApiService
import com.example.mtproject.model.Patches

class Repository(private val CSGOApiService: CSGOApiService) {
    suspend fun getPatches(): Patches {
        return CSGOApiService.getPatches();
    }


}

