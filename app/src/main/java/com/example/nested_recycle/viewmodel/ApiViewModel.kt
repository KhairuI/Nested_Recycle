package com.example.nested_recycle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nested_recycle.repository.MyRepository
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response


class ApiViewModel(private val repository: MyRepository):ViewModel() {

    // get Place List
    private val _nameResponse : MutableLiveData<Response<ResponseBody>> = MutableLiveData()
    val nameResponse : LiveData<Response<ResponseBody>> get() = _nameResponse

    fun getNameList() = viewModelScope.launch {
        _nameResponse.value = repository.getNameList()
    }
}