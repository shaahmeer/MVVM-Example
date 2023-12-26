package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.databinding.ActivityMainBinding
import com.example.mvvmexample.adapter.CountryListadapter
import com.example.mvvmexample.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var recycleradapter: CountryListadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleview()
        initViewModel()
    }

    private fun initRecycleview(){
        binding.countryRecycleView.layoutManager = LinearLayoutManager(this)
        recycleradapter = CountryListadapter(this)
        binding.countryRecycleView.adapter = recycleradapter


    }

    private fun initViewModel(){
        val viewModel : MainActivityViewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it!= null){
                recycleradapter.setCountryList(it)
                recycleradapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error in getting list",Toast.LENGTH_LONG).show()
            }

        })
        viewModel.makeAPICall()
    }
}