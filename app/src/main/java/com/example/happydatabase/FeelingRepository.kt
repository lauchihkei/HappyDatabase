package com.example.happydatabase

import androidx.lifecycle.LiveData

class FeelingRepository(private val feelingDao : FeelingDAO) {

    val allFeelings : LiveData<List<Feeling>> = feelingDao.getAllRecords()
    //this list will later on be used by view model , can do read write method
    //use this repository to do insertion of class

    suspend fun insertFeeling(feeling: Feeling){
        feelingDao.insertFeeling(feeling)
    }



}