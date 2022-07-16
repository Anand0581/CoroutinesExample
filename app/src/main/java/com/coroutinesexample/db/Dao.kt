package com.coroutinesexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coroutinesexample.models.HomeResponseModel

//
// Created by Anand Kashyap on 29/04/22.
//

@Dao
interface Dao {

    @Query("SELECT * FROM home_response")
    suspend fun getResponse() : HomeResponseModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // or OnConflictStrategy.IGNORE
    suspend fun insertResponse(response : HomeResponseModel)
}