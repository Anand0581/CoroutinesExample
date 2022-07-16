package com.coroutinesexample.models

import com.google.gson.annotations.SerializedName


data class Products (

  @SerializedName("id"                ) var id               : Int?    = null,
  @SerializedName("name"              ) var name             : String? = null,
  @SerializedName("banner_image"      ) var bannerImage      : String? = null,
  @SerializedName("dominantColor"     ) var dominantColor    : String? = null,
  @SerializedName("price"             ) var price            : String? = null,
  @SerializedName("regular_price"     ) var regularPrice     : String? = null,
  @SerializedName("average_rating"    ) var averageRating    : String? = null,
  @SerializedName("short_description" ) var shortDescription : String? = null

)