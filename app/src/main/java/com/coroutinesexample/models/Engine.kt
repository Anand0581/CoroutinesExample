package com.coroutinesexample.models

import javax.inject.Inject

//
// Created by Anand Kashyap on 06/05/22.
//

open class Engine @Inject constructor() {

    fun getEngineCC():String {
        return "1200CC"
    }
}