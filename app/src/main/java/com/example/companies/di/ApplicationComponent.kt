package com.example.companies.di

import android.app.Application
import com.example.companies.presentation.fragmentList.ListCompanyFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class])
interface ApplicationComponent {

    fun inject(fragment: ListCompanyFragment)

    @Component.Factory
    interface Factory{

        fun  create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}