package com.example.companies.data.retrofit.service

import com.example.companies.model.Company
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CompaniesService {

    @GET("test.php")
    fun getCompany(@Query("id") id: Int): Call<ResponseBody>

    @GET("test.php/")
    fun getListCompanies(): Call<List<Company>>

}