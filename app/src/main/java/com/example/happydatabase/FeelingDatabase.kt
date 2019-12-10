package com.example.happydatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Feeling :: class) , version = 1)
abstract class FeelingDatabase : RoomDatabase() {

    //Instance of DAO
    abstract fun feelingDao() : FeelingDAO

    //Ensure only one instance of the database is created
    companion object{
        @Volatile
        private var INSTANCE: FeelingDatabase? = null

        fun getDatabase(context: Context):FeelingDatabase{
            //return the instance of database

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            //create instance of the database if have not created
            //take time to build all the table
            //in function coroutine use suspend, synchronize method

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FeelingDatabase :: class.java,
                    "feeling_db"
                ).build()
                INSTANCE = instance
                
                return instance
            }
        }
    }
}