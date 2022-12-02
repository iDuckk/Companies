package com.example.companies.presentation.fragmentDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.companies.domain.useCases.GetCompany
import com.example.companies.model.DetailsCompany
import com.example.companies.utils.ParseJSON
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class DetailsCompanyViewModel@Inject constructor(
    private val getCompany: GetCompany
): ViewModel() {

    @Inject
    lateinit var parseJSON: ParseJSON

    var job: Job? = null

    private val _dCompany = MutableLiveData<DetailsCompany>()
    val dCompany: LiveData<DetailsCompany>
        get() = _dCompany
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun getCompany(id: Int){
        job = CoroutineScope(Dispatchers.IO).launch {
            getCompany.invoke(id).enqueue(object: retrofit2.Callback<ResponseBody>{
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                    val stringResponse = response.body()?.string() //Сырой JSON строкой

                    _dCompany.postValue(parseJSON.invoke(stringResponse!!))
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    _errorMessage.postValue("ListCompaniesViewModel: ${t.message}")
                }

            })
        }
    }

    companion object{
        const val ESCAPING_QUOTES = "\\"
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}