package com.example.happydatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "feeling")
data class Feeling (
    @PrimaryKey(autoGenerate = true )
    val id:Int ,
    val mode:Int , // 1= sad . 2 = neutra, 3 = happy
    val remarks : String ,
    val created_at: Long = System.currentTimeMillis()

)

