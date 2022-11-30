package com.example.companies.domain.repository

import com.example.companies.model.Company
import retrofit2.Call

interface CompaniesRepository {

    suspend fun getCompany(id : Int) : Call<Company>

    suspend fun getListCompanies() : Call<List<Company>>

}