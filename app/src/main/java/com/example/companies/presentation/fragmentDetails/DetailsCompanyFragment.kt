package com.example.companies.presentation.fragmentDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.companies.CompaniesApplication
import com.example.companies.R
import com.example.companies.databinding.FragmentDetailsCompanyBinding
import com.example.companies.databinding.FragmentListCompanyBinding
import com.example.companies.presentation.adapters.companiesAdapter.onClickListenerItem
import com.example.companies.presentation.fragmentList.ListCompaniesViewModel
import javax.inject.Inject

class DetailsCompanyFragment : Fragment() {

    private var _binding: FragmentDetailsCompanyBinding? = null
    private val binding: FragmentDetailsCompanyBinding get() = _binding!!

    @Inject
    lateinit var viewModel: DetailsCompanyViewModel

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
        _binding = FragmentDetailsCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setContent()

    }

    companion object {
        const val ID_COMPANY_KEY = "id_company_key"
        const val ZERO = 0.0
        const val EMPTY = ""
        const val IMAGE_URL = "https://lifehack.studio/test_task/"
    }

    private fun setContent() {
        arguments?.getInt(ID_COMPANY_KEY).let {
            viewModel.getCompany(it!!)
        }

        viewModel.dCompany.observe(viewLifecycleOwner) {
            //Set Image
            Glide
                .with(requireContext())
                .load("$IMAGE_URL${it.img}")
                .error(R.drawable.ic_android)
                .into(binding.imLogo)
            //Set text views
            binding.tvNameDetail.text = it.name
            binding.tvDesc.text = it.description
            binding.tvWww.text = it.www
            binding.tvPhone.text = it.phone
            //Set visibility of lat, lon
            if (it.lat != ZERO || it.lon != ZERO) {
                binding.tvLatContent.text = it.lat.toString()
                binding.tvLonContent.text = it.lon.toString()
            } else {
                binding.tvLatContent.visibility = View.INVISIBLE
                binding.tvLonContent.visibility = View.INVISIBLE
                binding.tvLat.visibility = View.INVISIBLE
                binding.tvLon.visibility = View.INVISIBLE
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}