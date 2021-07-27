package com.example.cleanarchitectureapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureapp.App
import com.example.cleanarchitectureapp.R
import com.example.cleanarchitectureapp.data.DummyData
import com.example.cleanarchitectureapp.databinding.DataItemBinding
import java.text.SimpleDateFormat
import java.util.*

class DummyDataViewHolder (val binding: DataItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: DummyData) {
        binding.title.text = data.title
        binding.id.text = data.id.toString()
        binding.userId.text = data.userId.toString()
        binding.body.text = data.body

    }
}