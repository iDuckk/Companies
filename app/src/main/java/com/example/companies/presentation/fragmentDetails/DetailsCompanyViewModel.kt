package com.example.companies.presentation.fragmentDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.companies.domain.useCases.GetCompany
import com.example.companies.model.DetailsCompany
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class DetailsCompanyViewModel@Inject constructor(
    private val getCompany: GetCompany
): ViewModel() {

    var job: Job? = null

    private val _dCompany = MutableLiveData<DetailsCompany>()
    val dCompany: LiveData<DetailsCompany>
        get() = _dCompany
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun getCompany(id: Int){
        job = CoroutineScope(Dispatchers.IO).launch {
            getCompany.invoke(id).enqueue(object: retrofit2.Callback<List<DetailsCompany>>{
                override fun onResponse(call: Call<List<DetailsCompany>>, response: Response<List<DetailsCompany>>) {
                    //Get data
                    _dCompany.postValue(response.body()!!.get(0))
                }

                override fun onFailure(call: Call<List<DetailsCompany>>, t: Throwable) {
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