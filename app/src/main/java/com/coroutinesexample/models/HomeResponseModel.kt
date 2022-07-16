package com.coroutinesexample.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "home_response")
data class HomeResponseModel(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 1,

    @ColumnInfo(name = "homepage_products") @SerializedName("homepage_products") var homepageProducts: ArrayList<HomepageProducts> = arrayListOf(),
    @ColumnInfo(name = "banners") @SerializedName("banners") var banners: ArrayList<Banners> = arrayListOf(),
//    @ColumnInfo(name = "featured_category") @SerializedName("featured_category") var featuredCategory: ArrayList<String> = arrayListOf(),
//    @ColumnInfo(name = "categories") @SerializedName("categories") var categories: ArrayList<Categories> = arrayListOf(),
//    @ColumnInfo(name = "settings") @SerializedName("settings") var settings: Settings? = Settings(),
//    @ColumnInfo(name = "count") @SerializedName("count") var count: String? = null

)