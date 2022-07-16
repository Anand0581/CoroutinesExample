package com.coroutinesexample.models

//@Entity(tableName = "home_response")
data class HomePageResponse (

//    @PrimaryKey(autoGenerate = true)
    var id : Int = 1,


//    @SerializedName("homepage_products" )  @TypeConverters(Converters::class) var homepageProducts : ArrayList<HomepageProducts> = arrayListOf(),
//
//    @ColumnInfo(name = "name")
    var name : String ?= null,

//    @ColumnInfo(name = "parents_name")
    var parents_name : String ?= null

)