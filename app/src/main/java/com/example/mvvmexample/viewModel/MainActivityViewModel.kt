package com.example.mvvmexample.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.UserProfile
import com.example.mvvmexample.retrofit.RetroServiceInterface
import com.example.mvvmexample.retrofit.retroInstance
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var livedataList: MutableLiveData<List<UserProfile>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<UserProfile>> {
        return livedataList
    }

    fun makeAPICall() {
        val retroInstance = retroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getCountryList()
        call.enqueue(object : retrofit2.Callback<List<UserProfile>> {
            override fun onResponse(
                call: Call<List<UserProfile>>,
                response: Response<List<UserProfile>>
            ) {
                livedataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UserProfile>>, t: Throwable) {
                livedataList.postValue(null)
            }
        })
    }
}
