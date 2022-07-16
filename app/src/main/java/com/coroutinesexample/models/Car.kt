package com.coroutinesexample.models

import android.util.Log
import javax.inject.Inject

//
// Created by Anand Kashyap on 06/05/22.
//

class Car @Inject constructor(val engine: Engine) {

    fun printEngineCC(){
        Log.d("TAG", "printEngineCC: ${engine.getEngineCC()} ")
    }
}