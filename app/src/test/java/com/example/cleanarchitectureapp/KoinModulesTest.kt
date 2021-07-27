package com.example.cleanarchitectureapp

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.cleanarchitectureapp.di.databaseModule
import com.example.cleanarchitectureapp.di.networkModule
import com.example.cleanarchitectureapp.di.presentationModule
import com.example.cleanarchitectureapp.di.repositoryModule
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class KoinModulesTest : KoinTest {
    val appContext = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun `test koin modules`() {
        startKoin {
            //For logging Koin related errors
            androidLogger()
            //Declare my app context
            androidContext(appContext)
            modules(listOf(
                databaseModule, presentationModule,
                repositoryModule, networkModule
            ))
        }.checkModules()
    }

    @After
    fun `Stop Koin`() {
        stopKoin()
    }
}