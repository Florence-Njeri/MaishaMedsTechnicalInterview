package com.example.cleanarchitectureapp

import android.app.Application
import android.content.Context

import com.example.cleanarchitectureapp.di.databaseModule
import com.example.cleanarchitectureapp.di.networkModule
import com.example.cleanarchitectureapp.di.presentationModule
import com.example.cleanarchitectureapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App:Application() {
    companion object{
        private lateinit var instance: App
        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Initialize Koin
        startKoin {
            //For logging Koin related errors
            androidLogger(Level.DEBUG)
            //Declare my app context
            androidContext(instance.applicationContext)
            //Declare all my D.I modules
            modules(
                listOf(
                    networkModule, databaseModule, presentationModule,
                    repositoryModule
                )
            )
        }
    }
    }