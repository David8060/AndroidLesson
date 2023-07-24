package com.example.mvvmroom.model.retrofit


import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("breeds")
    suspend fun callApi(): Response<GetData>
}