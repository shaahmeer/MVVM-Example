package com.example.mvvmexample.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexample.data.UserProfile
import com.example.mvvmexample.databinding.CountryListRowBinding

class CountryListadapter(val activity: Activity): RecyclerView.Adapter<CountryListadapter.MyViewHolder>() {
    private var userProfileList: List<UserProfile>? = null

    fun setCountryList(userProfileList: List<UserProfile>?) {
        this.userProfileList = userProfileList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListadapter.MyViewHolder {
        val binding = CountryListRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryListadapter.MyViewHolder, position: Int) {
        userProfileList?.get(position)?.let { holder.bind(it, activity) }
    }

    override fun getItemCount(): Int {
        return userProfileList?.size ?: 0
    }

    inner class MyViewHolder(private val binding: CountryListRowBinding): RecyclerView.ViewHolder(binding.root) {
        val tvName = binding.textViewId
        val tvCapital = binding.textViewLogin
        val tvRegion = binding.textViewNodeId
        val avatar = binding.textViewAvatarUrl

        fun bind(data: UserProfile, activity: Activity) {
            tvName.text = data.login
            tvCapital.text = data.id.toString()
            tvRegion.text = data.node_id

            Glide.with(activity)
                .load(data.avatar_url)
                .into(avatar)
        }
    }
}
