package com.coroutinesexample.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.coroutinesexample.R
import com.coroutinesexample.databinding.ActivityMainBinding
import com.coroutinesexample.db.MyRoomDatabase
import com.coroutinesexample.di.MainModules.viewModels
import com.coroutinesexample.models.Car
import com.coroutinesexample.network.ApiInterface
import com.coroutinesexample.network.RetrofitApiClient
import com.coroutinesexample.repo.Repository
import com.coroutinesexample.viewModels.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityMainBinding

    @Inject lateinit var db : MyRoomDatabase
    @Inject lateinit var retrofit: Retrofit
    @Inject lateinit var car: Car
    @Inject lateinit var repo: Repository
    @Inject lateinit var viewModel: HomePageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel.getHomePage()?.observeForever {
            mBinding.data = it.toString()
        }
//        From Room Database
//        viewModel.getHomePageFromDataBase()?.observe(this,{
//            Log.d("ANAND", "ANAND: $it")
//        })
//        From RxJava API Call
//        viewModel.getHomePageRxJava()?.observeForever {
//            mBinding.data = it.toString()
//        }
        car.printEngineCC()
    }

}