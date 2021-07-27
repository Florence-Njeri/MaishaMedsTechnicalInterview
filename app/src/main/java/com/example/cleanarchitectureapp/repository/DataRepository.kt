package com.example.cleanarchitectureapp.repository

import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.cleanarchitectureapp.App
import com.example.cleanarchitectureapp.data.DummyData
import com.example.cleanarchitectureapp.data.Success
import com.example.cleanarchitectureapp.network.NetworkStatusChecker
import com.example.cleanarchitectureapp.network.RemoteApi

@RequiresApi(Build.VERSION_CODES.M)
interface DataRepository{
    fun fetchData(): LiveData<List<DummyData>>
    suspend fun refreshData()
}