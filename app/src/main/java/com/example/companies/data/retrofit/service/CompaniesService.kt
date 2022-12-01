package com.example.companies.data.retrofit.service

import com.example.companies.model.Company
import com.example.companies.model.DetailsCompany
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CompaniesService {

    @GET("test.php")
    fun getCompany(@Query("id") id: Int): Call<List<DetailsCompany>>

    @GET("test.php/")
    fun getListCompanies(): Call<List<Company>>

}