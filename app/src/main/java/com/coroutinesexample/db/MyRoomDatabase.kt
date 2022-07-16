package com.coroutinesexample.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.coroutinesexample.db.converters.BannerConverter
import com.coroutinesexample.db.converters.HomeProductConverter
import com.coroutinesexample.models.HomeResponseModel

//
// Created by Anand Kashyap on 29/04/22.
//

@Database(entities = [HomeResponseModel::class], version = 1)
@TypeConverters(HomeProductConverter::class, BannerConverter::class)
abstract class MyRoomDatabase : RoomDatabase(){

    companion object{
        const val DB_NAME = "home_response"
        private var INSTANCE : MyRoomDatabase ?= null

        fun getInstance(context: Context) : MyRoomDatabase{
            if (INSTANCE == null){
                synchronized(MyRoomDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context,MyRoomDatabase::class.java,
                        DB_NAME).build()
                }

            }
            return INSTANCE!!
        }

    }

    abstract fun dao() : Dao
}