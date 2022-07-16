package com.coroutinesexample.network

import com.coroutinesexample.models.HomeResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

//
// Created by Anand Kashyap on 11/04/22.
//

interface ApiInterface {

    @GET("homepage/?width=41&guest_id=&mFactor=3.5")
    suspend fun homepage() : Response<HomeResponseModel>


    @GET("homepage/?width=41&guest_id=&mFactor=3.5")
    fun getHomePageFromRxJava() : Observable<HomeResponseModel>
}