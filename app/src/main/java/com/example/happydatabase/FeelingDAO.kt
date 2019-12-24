package com.example.happydatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FeelingDAO {

    // can do crud for database

    @Insert
    suspend fun insertFeeling(feeling:Feeling)

    //suspend is a coroutine function, this method that insert feeling will execute as a  background process, will take time
    //must put

    @Update
    suspend fun updateFeeling(feeling: Feeling)

    @Delete
    suspend fun deleteFeeling(feeling: Feeling)

    @Query("SELECT * FROM feeling")
    fun getAllRecords(): LiveData<List<Feeling>>

    @Query("SELECT * FROM feeling WHERE id =:search_id")
    fun getOneRecord(search_id : Int) : Feeling
}