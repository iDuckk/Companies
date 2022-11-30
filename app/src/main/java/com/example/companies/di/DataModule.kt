package com.example.companies.di

import com.example.companies.data.retrofit.factory.ApiFactory
import com.example.companies.data.retrofit.repository.CompaniesRepositoryImpl
import com.example.companies.data.retrofit.service.CompaniesService
import com.example.companies.domain.repository.CompaniesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindCompaniesListRepository(impl: CompaniesRepositoryImpl): CompaniesRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): CompaniesService {
            return ApiFactory.getInstance().create(CompaniesService::class.java)
        }
    }

}