package com.example.internshipproject.api.repo

import com.example.internshipproject.api.network.RetrofitApiService


class Repository (private val retrofitApiService: RetrofitApiService) {

    suspend fun getUsers()=retrofitApiService.getUsers()

    suspend fun getPhotos()=retrofitApiService.getPhotos()



}