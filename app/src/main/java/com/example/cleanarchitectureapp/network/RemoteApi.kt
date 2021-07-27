package com.example.cleanarchitectureapp.network

import com.example.cleanarchitectureapp.data.DummyData
import com.example.cleanarchitectureapp.data.Failure
import com.example.cleanarchitectureapp.data.Result
import com.example.cleanarchitectureapp.data.Success

const val BASE_URL = "https://jsonplaceholder.typicode.com"
class RemoteApi(private val remoteApiService: RemoteApiService) {
    suspend fun getDataFeed(): Result<List<DummyData>> = try {

        val body = remoteApiService.getApiFeed()
        Success(body)
    } catch (error: Throwable) {
        Failure(error)
    }
}
