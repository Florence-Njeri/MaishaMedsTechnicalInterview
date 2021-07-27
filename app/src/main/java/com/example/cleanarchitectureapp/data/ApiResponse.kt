package com.example.cleanarchitectureapp.data

import kotlinx.serialization.Serializable

@Serializable
class ApiResponse(val data: List<DummyData>) {
}