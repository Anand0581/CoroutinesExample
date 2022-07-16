package com.coroutinesexample.models

import com.google.gson.annotations.SerializedName


data class Banners (

  @SerializedName("id"            ) var id            : Int?    = null,
  @SerializedName("image"         ) var image         : String? = null,
  @SerializedName("dominantColor" ) var dominantColor : String? = null,
  @SerializedName("banner_type"   ) var bannerType    : String? = null

)