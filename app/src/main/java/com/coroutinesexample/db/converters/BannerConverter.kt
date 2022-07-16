package com.coroutinesexample.db.converters

import androidx.room.TypeConverter
import com.coroutinesexample.models.Banners
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//
// Created by Anand Kashyap on 05/05/22.
//
class BannerConverter {
    @TypeConverter
    fun fromHomepageBanners(value:ArrayList<Banners>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Banners>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toHomepageBanners(value: String): ArrayList<Banners> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Banners>>() {}.type
        return gson.fromJson(value, type)
    }
}