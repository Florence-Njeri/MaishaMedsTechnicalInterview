package com.example.cleanarchitectureapp.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cleanarchitectureapp.repository.DataRepository
import com.example.cleanarchitectureapp.repository.DataRepositoryImpl
import com.example.cleanarchitectureapp.network.RemoteApi
import org.koin.dsl.module

@RequiresApi(Build.VERSION_CODES.M)
val repositoryModule = module {
    single { RemoteApi(get()) }
    single<DataRepository> { DataRepositoryImpl(get(), get()) }
}