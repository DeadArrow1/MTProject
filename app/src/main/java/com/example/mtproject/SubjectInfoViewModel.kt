package com.example.mtproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtproject.Domain.PatchDomain
import com.example.mtproject.model.Patches
import com.example.mtproject.source.Repository
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch



class SubjectInfoViewModel (private val repository: Repository) : ViewModel()
{
    private val _patchValue = MutableLiveData<PatchDomain>()
    val patchValue: LiveData<PatchDomain> = _patchValue


    fun fetchPatchesFromRepository() {

        viewModelScope.launch {
            try {

                _patchValue.value = repository.getPatchesFromRepository().firstOrNull()
            } catch (e: Exception) {
                Log.v("MYAPP", "Not found: " + e.message)
            }
        }




//        viewModelScope.launch {
//
//            val patches = withContext(Dispatchers.IO) {
//                repository.getPatches();
//            }
//            patchLiveData.value=patches
//        }

    }

}