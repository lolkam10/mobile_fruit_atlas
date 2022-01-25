package com.example.project2_atlas.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project2_atlas.Entities.Fruits
@Database(entities=[Fruits::class], version = 1, exportSchema = false)
abstract class Database_Helper: RoomDatabase() {
    abstract val databaseDao:FruitDatabase_DAO

    companion object{
        @Volatile
        private var INSTANCE: Database_Helper?=null
        fun getInstance(context: Context):Database_Helper{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(context.applicationContext,Database_Helper::class.java,"Database_Helper").fallbackToDestructiveMigration().build()
                    INSTANCE = instance

                }
                return instance
            }


        }


    }


}
