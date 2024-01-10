package com.example.mtproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mtproject.source.Repository

class SubjectInfoViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubjectInfoViewModel::class.java)) {
            return SubjectInfoViewModel(repository) as T
        }
        throw IllegalArgumentException("Wrong ViewModel class")
    }
}