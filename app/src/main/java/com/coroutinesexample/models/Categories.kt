package com.coroutinesexample.models

import com.google.gson.annotations.SerializedName


data class Categories (

  @SerializedName("ID"            ) var ID            : Int?    = null,
  @SerializedName("name"          ) var name          : String? = null,
  @SerializedName("icon"          ) var icon          : String? = null,
  @SerializedName("dominantColor" ) var dominantColor : String? = null,
  @SerializedName("children"      ) var children      : Int?    = null

)