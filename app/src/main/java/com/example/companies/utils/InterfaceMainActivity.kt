package com.example.companies.utils

import android.widget.ImageView

interface InterfaceMainActivity {

    fun setTextActionBar(txt: String)

    fun visibilityArrowBack(visible: Boolean)

    fun arrowBack(): ImageView

}