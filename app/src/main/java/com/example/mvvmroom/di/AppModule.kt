package com.example.mvvmroom.di

import androidx.room.Room
import com.example.mvvmroom.model.retrofit.MyApi
import com.example.mvvmroom.model.repository.CatRepository
import com.example.mvvmroom.model.repository.CatRepositoryImpl
import com.example.mvvmroom.model.room.MyRoomDataBase
import com.example.mvvmroom.viewModels.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            MyRoomDataBase::class.java,
            "room_database"
        ).build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

    single {
        val database = get<MyRoomDataBase>()
        database.getDAO()
    }

    factory<CatRepository> { CatRepositoryImpl(get(), get()) }

    viewModel { MainActivityViewModel(get()) }

}