package com.coroutinesexample.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.coroutinesexample.db.Dao
import com.coroutinesexample.db.MyRoomDatabase
import com.coroutinesexample.models.Car
import com.coroutinesexample.models.Engine
import com.coroutinesexample.network.ApiInterface
import com.coroutinesexample.network.Const.baseUrl
import com.coroutinesexample.network.RetrofitApiClient
import com.coroutinesexample.repo.Repository
import com.coroutinesexample.viewModels.HomePageViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//
// Created by Anand Kashyap on 06/05/22.
//
@Module
@InstallIn(SingletonComponent::class)
object MainModules {

    @Provides
    @Singleton
    fun getDataBase(context: Application): MyRoomDatabase{
        return MyRoomDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun getRetrofitClient() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getEngine() : Engine{
        return Engine()
    }

    @Provides
    @Singleton
    fun getCar(engine: Engine) : Car{
        return Car(engine)
    }

    @Provides
    @Singleton
    fun provideDao(db:MyRoomDatabase) : Dao{
        return db.dao()
    }
    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit) : ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(dao: Dao,apiInterface: ApiInterface) : Repository{
        return Repository(dao,apiInterface)
    }

    @Provides
    @Singleton
    fun viewModels(repository: Repository): HomePageViewModel {
        return HomePageViewModel(repository)
    }

}