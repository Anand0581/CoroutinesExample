package com.coroutinesexample

import kotlin.Exception

//
// Created by Anand Kashyap on 21/04/22.
//

sealed class MySealed<out T>{
    data class Success<out T>(val response: T) : MySealed<T>()
    data class Error(val exception: Exception) : MySealed<Nothing>()
    data class Loading(val loading: Boolean) : MySealed<Nothing>()
}
