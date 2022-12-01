package com.example.companies.presentation.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.companies.R
import com.example.companies.databinding.ActivityMainBinding
import com.example.companies.utils.InterfaceMainActivity

class MainActivity : AppCompatActivity(), InterfaceMainActivity {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setTextActionBar(txt: String) {
        binding.tvTitle.text = txt
    }

    override fun visibilityArrowBack(visible: Boolean) {
        if(visible) binding.imBack.visibility = View.VISIBLE
        else binding.imBack.visibility = View.GONE
    }

    override fun arrowBack(): ImageView {
        return binding.imBack
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}