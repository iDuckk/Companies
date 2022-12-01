package com.example.companies.domain.repository

import com.example.companies.model.Company
import com.example.companies.model.DetailsCompany
import retrofit2.Call

interface CompaniesRepository {

    suspend fun getCompany(id : Int) : Call<List<DetailsCompany>>

    suspend fun getListCompanies() : Call<List<Company>>

}