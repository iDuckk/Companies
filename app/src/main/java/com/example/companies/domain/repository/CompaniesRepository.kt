package com.example.companies.domain.repository

import androidx.lifecycle.LiveData
import com.example.companies.domain.model.Company
import retrofit2.Call

interface CompaniesRepository {

    suspend fun getCompany(id : Int) : Call<List<Company>>

    fun getListCompanies() : LiveData<List<Company>>

}