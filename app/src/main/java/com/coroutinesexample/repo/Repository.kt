package com.coroutinesexample.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.coroutinesexample.db.Dao
import com.coroutinesexample.db.MyRoomDatabase
import com.coroutinesexample.models.HomePageResponse
import com.coroutinesexample.models.HomeResponseModel
import com.coroutinesexample.network.ApiInterface
import com.coroutinesexample.network.RetrofitApiClient
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//
// Created by Anand Kashyap on 11/04/22.
//
const val TAG = "ANAND"
class Repository @Inject constructor(private val dao: Dao,private val apiInterface: ApiInterface) {
    private var homePageResponse : MutableLiveData<HomeResponseModel> = MutableLiveData()
    private var homeResponseDatabase: MutableLiveData<HomeResponseModel> = MutableLiveData()

    fun getData() : MutableLiveData<HomeResponseModel> {
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface?.homepage()
            withContext(Dispatchers.Main){
                homePageResponse.postValue(response?.body())
                insertData(response?.body()!!)
            }
        }
        return homePageResponse
    }

    fun getDataFromDatabase() : MutableLiveData<HomeResponseModel>{
        CoroutineScope(Dispatchers.IO).launch{
            val data = dao.getResponse()
            withContext(Dispatchers.Main){
                homeResponseDatabase.postValue(data)
            }
        }
        return homeResponseDatabase
    }

    private fun insertData(responseModel: HomeResponseModel){
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertResponse(responseModel)
        }
    }

    fun apiCallFromRxJava(): MutableLiveData<HomeResponseModel>{
        apiInterface.getHomePageFromRxJava()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<HomeResponseModel>{
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe: ")
                }

                override fun onNext(t: HomeResponseModel) {
                    Log.d(TAG, "onNext: $t")
                    homePageResponse.postValue(t)
                    insertData(t)
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "onNext: ${e.message}")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete: ")
                }

            })
        return homePageResponse
    }
}