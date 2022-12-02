package com.example.companies.data.retrofit.factory

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory {
    private val BASE_URL = "https://lifehack.studio/test_task/"

    fun getInstance(): Retrofit =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}