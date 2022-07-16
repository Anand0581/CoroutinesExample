package com.coroutinesexample.db.converters

import androidx.room.TypeConverter
import com.coroutinesexample.models.Banners
import com.coroutinesexample.models.HomepageProducts
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//
// Created by Anand Kashyap on 05/05/22.
//

class HomeProductConverter {

    @TypeConverter
    fun fromHomepageProducts(value:ArrayList<HomepageProducts>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<HomepageProducts>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toHomepageProducts(value: String): ArrayList<HomepageProducts> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<HomepageProducts>>() {}.type
        return gson.fromJson(value, type)
    }
}