package com.example.cleanarchitectureapp.repository

import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.cleanarchitectureapp.App
import com.example.cleanarchitectureapp.cache.Dao
import com.example.cleanarchitectureapp.data.DummyData
import com.example.cleanarchitectureapp.data.Success
import com.example.cleanarchitectureapp.network.NetworkStatusChecker
import com.example.cleanarchitectureapp.network.RemoteApi

@RequiresApi(Build.VERSION_CODES.M)
class DataRepositoryImpl(val remoteApi: RemoteApi, val dao: Dao) : DataRepository {
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(App.getAppContext().getSystemService(ConnectivityManager::class.java))
    }

    override fun fetchData(): LiveData<List<DummyData>> = dao.getData()

    override suspend fun refreshData() {
        //Refresh the database data once a user is connected to the internet
        networkStatusChecker.performIfConnectedToTheInternet {
            val result = remoteApi.getDataFeed()
            if (result is Success) {
                return dao.insertData(result.data)
            }
        }
    }
}