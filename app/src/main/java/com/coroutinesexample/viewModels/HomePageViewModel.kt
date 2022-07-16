package com.coroutinesexample.viewModels

import android.content.Context
import androidx.lifecycle.*
import com.coroutinesexample.models.HomePageResponse
import com.coroutinesexample.models.HomeResponseModel
import com.coroutinesexample.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//
// Created by Anand Kashyap on 11/04/22.
//
@HiltViewModel
class HomePageViewModel @Inject constructor(private val repo: Repository) : ViewModel() {

    fun getHomePage(): MutableLiveData<HomeResponseModel>? {
        return repo.getData()
    }
    fun getHomePageRxJava(): MutableLiveData<HomeResponseModel>? {
        return repo.apiCallFromRxJava()
    }
    fun getHomePageFromDataBase(): MutableLiveData<HomeResponseModel>? {
        return repo.getDataFromDatabase()
    }

//    class HomePageFactory(private val repo : Repository) : ViewModelProvider.Factory{
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return HomePageViewModel(repo) as T
//        }
//
//    }

}