package com.example.mvvmexample.retrofit

import com.example.mvvmexample.data.UserProfile
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("/users")
    fun getCountryList(): Call<List<UserProfile>>
}