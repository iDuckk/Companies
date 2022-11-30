package com.example.companies.data.retrofit.repository

import com.example.companies.data.retrofit.service.CompaniesService
import com.example.companies.domain.repository.CompaniesRepository
import javax.inject.Inject

class CompaniesRepositoryImpl@Inject constructor(
    private val companyService: CompaniesService): CompaniesRepository {

    override suspend fun getCompany(id: Int) = companyService.getCompany(id)

    override suspend fun getListCompanies() = companyService.getListCompanies()


}