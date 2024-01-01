package com.example.mtproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtproject.model.Patch
import com.example.mtproject.model.Patches
import com.example.mtproject.retrofit.RetrofitApi
import com.example.mtproject.retrofit.RetrofitInstance
//import com.example.mtproject.source.ManualParsingImpl
import com.example.mtproject.source.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SubjectInfoViewModel : ViewModel()
{
    //private val repository = Repository(ManualParsingImpl())
    private val repository = Repository(RetrofitInstance.service)

    val patchLiveData = MutableLiveData<Patches>()
    fun fetchPatchesFromRepository() {

        viewModelScope.launch {

            val patches = withContext(Dispatchers.IO) {
                repository.getPatches();
            }
            patchLiveData.value=patches
        }

    }

}