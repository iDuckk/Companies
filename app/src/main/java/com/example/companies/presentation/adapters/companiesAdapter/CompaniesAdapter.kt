package com.example.companies.presentation.adapters.companiesAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.companies.R
import com.example.companies.databinding.ItemCompanyBinding
import com.example.companies.model.Company
import com.example.companies.presentation.fragmentDetails.DetailsCompanyFragment
import javax.inject.Inject

var onClickListenerItem: ((item: Company) -> Unit)? = null
const val IMAGE_URL = "https://lifehack.studio/test_task/"

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

        //Set Image
        Glide
            .with(holder.itemView.context)
            .load("${IMAGE_URL}${item.img}")
            .circleCrop()
            .error(R.drawable.ic_android)
            .into(holder.img)

        holder.itemView.setOnClickListener {
            onClickListenerItem?.invoke(item)
        }
    }
}

