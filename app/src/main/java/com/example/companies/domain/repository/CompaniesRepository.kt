package com.example.companies.domain.repository

import com.example.companies.model.Company
import okhttp3.ResponseBody
import retrofit2.Call

interface CompaniesRepository {

    suspend fun getCompany(id : Int) : Call<ResponseBody>

    suspend fun getListCompanies() : Call<List<Company>>

}