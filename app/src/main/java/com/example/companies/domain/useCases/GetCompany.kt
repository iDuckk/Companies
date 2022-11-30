package com.example.companies.domain.useCases

import com.example.companies.domain.repository.CompaniesRepository
import javax.inject.Inject

class GetCompany@Inject constructor(private val repo : CompaniesRepository) {

    suspend operator fun invoke(id: Int) = repo.getCompany(id)

}