package com.example.cleanarchitectureapp.ui.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureapp.R
import com.example.cleanarchitectureapp.ui.adapter.DummyDataAdapter
import com.example.cleanarchitectureapp.ui.viewmodel.MainActivityViewModel
import org.koin.android.ext.android.inject


@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity() {
    val dataAdapter by lazy {
        DummyDataAdapter()
    }

    //Fetch the ViewModel Instance using Koin
    private val viewModel: MainActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.refreshData()
        viewModel.getDummyData().observe(this, Observer() {
            //Set up the RecyclerView
            dataAdapter.submitList(it)
            val dataList = findViewById<RecyclerView>(R.id.dataList)
            dataList.adapter = dataAdapter
        })

    }
}