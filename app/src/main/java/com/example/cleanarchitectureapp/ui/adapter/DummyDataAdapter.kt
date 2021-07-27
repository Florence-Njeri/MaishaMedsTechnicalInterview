package com.example.cleanarchitectureapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.cleanarchitectureapp.data.DummyData
import com.example.cleanarchitectureapp.databinding.DataItemBinding

class DummyDataAdapter: ListAdapter<DummyData, DummyDataViewHolder>(DataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyDataViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataItemBinding.inflate(layoutInflater, parent, false)
        return DummyDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DummyDataViewHolder, position: Int) {
        //Show the right view depending on the users position in scrolling
        val itemBook = getItem(position)
        holder.bind(itemBook)
    }

}

class DataDiffCallback : DiffUtil.ItemCallback<DummyData>() {
    //Checks if it is the same data item
    override fun areItemsTheSame(oldItem: DummyData, newItem: DummyData): Boolean {
        return oldItem.id == newItem.id
    }

    //Check whether the oldItem and the newItem contain the same ata
    override fun areContentsTheSame(oldItem: DummyData, newItem: DummyData): Boolean {
        return oldItem == newItem
    }
}