package com.example.mtproject

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.mtproject.DB.RoomDB.PatchDTO
import com.example.mtproject.Domain.PatchDomain
import com.example.mtproject.model.Patches
import com.example.mtproject.source.Repository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch



class SubjectInfoViewModel (private val repository: Repository) : ViewModel()
{
    private val _patchValue = MutableLiveData<Array<PatchDTO>>()
    val patchValue: LiveData <Array<PatchDTO>> = _patchValue
    val array: ArrayList<PatchDTO> = ArrayList()

    fun fetchPatchesFromRepository() {

        viewModelScope.launch {
            try {
                        // Step 2: Convert the list into an array
                repository.getPatchesFromRepository().collect {
                    it.forEach{ categoryItem ->
                        array.add(categoryItem)
                        Log.i("tag",categoryItem.toString())

                    }
                    _patchValue.value = array.toTypedArray()
                    Log.i("Array",array.toString())
                }
                Log.i("Array","return")


                }

         catch (e: Exception) {
            Log.v("MYAPP", "Not found: " + e.message)
        }
    }
    }
}
