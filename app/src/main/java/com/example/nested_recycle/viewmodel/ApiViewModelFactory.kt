package com.example.nested_recycle.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nested_recycle.repository.MyRepository

class ApiViewModelFactory(private val repository: MyRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ApiViewModel::class.java)){
            return ApiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}