package com.example.internshipproject.api.network

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/***

object RetrofitInstance{

val BaseURL = "http://jsonplaceholder.typicode.com"

private val retrofit by lazy{
Retrofit.Builder()
.baseUrl(BaseURL)
.addConverterFactory(GsonConverterFactory.create())
.build()
}

val api: RetrofitApiService by lazy{
retrofit.create(RetrofitApiService::class.java)
}

}
 */