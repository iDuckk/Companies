package com.example.companies.presentation.adapters.companiesAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.companies.model.Company

class CompaniesCallback: DiffUtil.ItemCallback<Company>() {
    override fun areItemsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem == newItem
    }
}