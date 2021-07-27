package com.example.cleanarchitectureapp.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureapp.repository.DataRepository
import com.example.cleanarchitectureapp.data.DummyData
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

@RequiresApi(Build.VERSION_CODES.M)

class MainActivityViewModel(val dataRepository: DataRepository): ViewModel(),KoinComponent {
    private val _data = MutableLiveData<List<DummyData>>()
    val data: LiveData<List<DummyData>> get() = _data

    fun getDummyData() = dataRepository.fetchData()

    fun refreshData() {
        viewModelScope.launch {
            dataRepository.refreshData()
        }
    }
}