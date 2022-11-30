package com.example.companies.domain.useCases

import com.example.companies.domain.repository.CompaniesRepository
import javax.inject.Inject

class GetCompaniesListUseCase@Inject constructor(private val repo : CompaniesRepository) {

    operator fun invoke() = repo.getListCompanies()

}