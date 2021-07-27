package com.example.cleanarchitectureapp.network

import com.example.cleanarchitectureapp.data.ApiResponse
import com.example.cleanarchitectureapp.data.DummyData
import retrofit2.http.GET

interface RemoteApiService {
    @GET("/posts")
    suspend fun getApiFeed(): List<DummyData>
}