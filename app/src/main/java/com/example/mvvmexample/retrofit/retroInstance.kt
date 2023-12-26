package com.example.mvvmexample.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retroInstance {

    companion object{
        val BASE_URL = "https://api.github.com" //all"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                   .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }



    }
}