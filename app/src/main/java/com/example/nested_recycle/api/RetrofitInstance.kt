package com.example.nested_recycle.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val  retrofit by lazy {
        Retrofit.Builder().baseUrl("https://random-data-api.com/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    val api:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}