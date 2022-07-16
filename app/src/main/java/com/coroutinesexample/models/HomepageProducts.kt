package com.coroutinesexample.models

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName


data class HomepageProducts (

  @SerializedName("title"    ) @ColumnInfo(name = "title") var title    : String? = null,
  @SerializedName("products" ) var products : ArrayList<Products> = arrayListOf()

)