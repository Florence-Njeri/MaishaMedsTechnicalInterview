package com.example.cleanarchitectureapp.di

import com.example.cleanarchitectureapp.network.RemoteApiService
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Build the ApiService object here so as it is inject in the RemoteApi for fetching data from the remote data source
 */
val networkModule = module {
    single {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single<Converter.Factory> { GsonConverterFactory.create() }
    single {
        //Build the content type for your Kotlin parser
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    }
    single {
        get<Retrofit>().create(RemoteApiService::class.java)
    }
}
private const val BASE_URL = "https://jsonplaceholder.typicode.com"
