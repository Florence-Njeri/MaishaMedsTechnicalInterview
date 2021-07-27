package com.example.cleanarchitectureapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
@Serializable
@Entity(tableName = "app_db")
data class DummyData(
    @ColumnInfo(name = "userId") val userId: Int,
    @PrimaryKey
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "body") val body:String)