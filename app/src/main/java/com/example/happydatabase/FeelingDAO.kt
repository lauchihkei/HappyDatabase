package com.example.happydatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FeelingDAO {

    // can do crud for database

    @Insert
    suspend fun insertFeeling(feeling:Feeling)

    //suspend is a coroutine function, this method that insert feeling will execute as a  background process, will take time
    //must put

    @Query("SELECT * FROM feeling")
    suspend fun getAllRecords(): LiveData<List<Feeling>>

    @Query("SELECT * FROM feeling WHERE id =: search_id")
    suspend fun getOneRecord(search_id : Int)
}