package com.example.companies.presentation.fragmentList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.companies.domain.useCases.GetCompaniesListUseCase
import com.example.companies.model.Company
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ListCompaniesViewModel @Inject constructor(
    private val getList: GetCompaniesListUseCase
): ViewModel(){

    var job: Job? = null

    private val _companiesList = MutableLiveData<List<Company>>()
    val companiesList: LiveData<List<Company>>
        get() = _companiesList
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun getCompaniesList(){
        job = CoroutineScope(Dispatchers.IO).launch {
            getList.invoke().enqueue(object: retrofit2.Callback<List<Company>>{
                override fun onResponse(call: Call<List<Company>>, response: Response<List<Company>>) {
                    //Get data
                    _companiesList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Company>>, t: Throwable) {
                    _errorMessage.postValue("ListCompaniesViewModel: ${t.message}")
                }

            })
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }



}