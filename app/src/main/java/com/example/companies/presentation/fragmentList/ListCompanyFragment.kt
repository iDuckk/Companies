package com.example.companies.presentation.fragmentList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companies.CompaniesApplication
import com.example.companies.R
import com.example.companies.databinding.FragmentListCompanyBinding
import com.example.companies.model.Company
import com.example.companies.presentation.adapters.companiesAdapter.CompaniesAdapter
import javax.inject.Inject

class ListCompanyFragment : Fragment() {

    private var _binding: FragmentListCompanyBinding? = null
    private val binding: FragmentListCompanyBinding get() = _binding!!

    @Inject
    lateinit var companiesAdapter: CompaniesAdapter

    private val component by lazy {
        (requireActivity().application as CompaniesApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecView()
    }

    companion object {

    }

    private fun initRecView() {
        with(binding.recViewCompanies){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
                false)
            adapter = companiesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}