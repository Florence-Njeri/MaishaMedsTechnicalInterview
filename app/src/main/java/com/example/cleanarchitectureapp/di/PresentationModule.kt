package com.example.cleanarchitectureapp.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cleanarchitectureapp.ui.viewmodel.MainActivityViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


@RequiresApi(Build.VERSION_CODES.M)
val presentationModule = module {
    viewModel { MainActivityViewModel(dataRepository = get()) }
}