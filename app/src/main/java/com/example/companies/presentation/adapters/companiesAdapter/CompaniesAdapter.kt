package com.example.companies.presentation.adapters.companiesAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.companies.databinding.ItemCompanyBinding
import com.example.companies.model.Company
import javax.inject.Inject

var onClickListenerItem: ((item: Int) -> Unit)? = null

class CompaniesAdapter @Inject constructor() :
    ListAdapter<Company, CompaniesViewHolder>(CompaniesCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        return CompaniesViewHolder(
            ItemCompanyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        val item = getItem(position)

        holder.name.text = item.name

        holder.itemView.setOnClickListener {
            onClickListenerItem?.invoke(item.id)
        }
    }
}

