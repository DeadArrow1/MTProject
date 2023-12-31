package com.example.mtproject.source

import com.example.mtproject.api.CSGOApiService
import com.example.mtproject.model.Patch
import com.example.mtproject.model.Patches
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.io.BufferedInputStream
import java.net.URL
import java.net.URLConnection

//class ManualParsingImpl:CSGOApiService {
//    override suspend fun getPatches(): Patches {
//
//        val url = URL("https://bymykel.github.io/CSGO-API/api/en/patches.json")
//        val connection : URLConnection= url.openConnection()
//        connection.connect()
//
//        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
//        val bufferedReader = bufferedInputStream.bufferedReader()
//
//        val stringBuffer=StringBuffer()
//
//        for(line in bufferedReader.readLines())
//        {
//            stringBuffer.append(line)
//        }
//        bufferedReader.close()
//
//        val fullJSON = stringBuffer.toString()
//
//        //JSON parsing
//
//
//        val jsonArray = JSONArray(fullJSON)
//        val jsonObjectPatch = jsonArray.getJSONObject(0)
//
//        val id=jsonObjectPatch.getString("id")
//        val name=jsonObjectPatch.getString("name")
//        val description=jsonObjectPatch.getString("description")
//        val image=jsonObjectPatch.getString("image")
//
//        return Patches(listOf(
//            Patch(
//                id,
//                name,
//                description,
//                image
//        )
//        ))
//    }
//}