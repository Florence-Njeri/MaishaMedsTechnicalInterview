package com.example.cleanarchitectureapp.cache


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cleanarchitectureapp.data.DummyData

@Database(entities = [(DummyData::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): Dao
    companion object {

        const val DATABASE_NAME = "app-db"

    }

}