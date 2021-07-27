package com.example.cleanarchitectureapp.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitectureapp.data.DummyData
//Interacts with the DummyData entity to get the data
@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(posts: List<DummyData>)

    @Query("SELECT * FROM app_db")
    fun getData(): LiveData<List<DummyData>>
}