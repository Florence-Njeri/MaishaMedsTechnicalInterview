package com.example.cleanarchitectureapp.di

import androidx.room.Room
import com.example.cleanarchitectureapp.cache.AppDatabase
import com.example.cleanarchitectureapp.cache.AppDatabase.Companion.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java,DATABASE_NAME).build()}
    single { get<AppDatabase>().appDao() }
}