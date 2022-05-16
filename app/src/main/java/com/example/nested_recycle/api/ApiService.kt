package com.example.nested_recycle.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users/random_user?size=10")
    suspend fun getNameList() : Response<ResponseBody>
}