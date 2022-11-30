package com.example.companies.data.retrofit.service

import com.example.companies.model.Company
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CompaniesService {

    @GET("{?id}")
    fun getCompany(@Path("id") id: Int): Call<Company>

    @GET()
    fun getListCompanies(): Call<List<Company>>

}