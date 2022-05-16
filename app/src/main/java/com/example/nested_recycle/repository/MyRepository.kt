package com.example.nested_recycle.repository

import com.example.nested_recycle.api.ApiService

class MyRepository(private val api:ApiService) {

    suspend fun getNameList()= api.getNameList()
}