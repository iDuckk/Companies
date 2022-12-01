package com.example.companies.presentation.adapters.companiesAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.companies.databinding.ItemCompanyBinding

class CompaniesViewHolder (binding: ItemCompanyBinding): RecyclerView.ViewHolder(binding.root){
    val name = binding.tvName
    val img = binding.imL
}