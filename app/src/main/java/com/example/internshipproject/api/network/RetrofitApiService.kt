package com.example.internshipproject.api.network

import com.example.internshipproject.api.data.Photo
import com.example.internshipproject.api.data.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitApiService {


    @GET("/users")
    suspend fun getUsers(): Response<List<User>>
    @GET("/photos")
    suspend fun getPhotos(): Response<List<Photo>>

    companion object{
        val BaseURL = "http://jsonplaceholder.typicode.com"

        var retrofitApiService:RetrofitApiService?=null


        fun getInstance():RetrofitApiService{

            if (retrofitApiService==null){
                val retrofit= Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitApiService=retrofit.create(RetrofitApiService::class.java)

            }
            return retrofitApiService!!
        }
    }


}