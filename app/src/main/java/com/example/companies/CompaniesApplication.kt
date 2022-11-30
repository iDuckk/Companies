package com.example.companies

import android.app.Application
import com.example.companies.di.DaggerApplicationComponent

class CompaniesApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

}