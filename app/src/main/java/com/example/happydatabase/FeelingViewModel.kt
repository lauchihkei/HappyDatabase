package com.example.happydatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FeelingViewModel(application: Application):AndroidViewModel(application) {

    private val repository : FeelingRepository

    val allFeelings : LiveData<List<Feeling>>


    init{
        val feelingDAO = FeelingDatabase.getDatabase(application).feelingDao()
        repository = FeelingRepository(feelingDAO)
        allFeelings = repository.allFeelings
    }
    //launch is a coroutine function
    //viewModelScope is within view model
    //globalScope is want to launch the coroutine
    fun insertFeeling(feeling:Feeling) = viewModelScope.launch {
        repository.insertFeeling(feeling)
    }

}