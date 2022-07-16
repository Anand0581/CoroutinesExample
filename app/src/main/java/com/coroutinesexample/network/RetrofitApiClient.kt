package com.coroutinesexample.network

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//
// Created by Anand Kashyap on 11/04/22.
//

class RetrofitApiClient {
    companion object {
        val baseUrl = "https://shoppingbrasaqui.com.br/wp-json/mobikul/v1/"

        private var retrofit: Retrofit ?= null

        fun getRetrofitClient() : Retrofit? {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }


}