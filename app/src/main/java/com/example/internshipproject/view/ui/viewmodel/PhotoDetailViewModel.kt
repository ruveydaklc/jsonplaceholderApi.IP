package com.example.internshipproject.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshipproject.api.data.Photo
import kotlinx.coroutines.launch

class PhotoDetailViewModel() : ViewModel() {

    val photoLiveData:MutableLiveData<Photo> = MutableLiveData()

    fun initData(photo:Photo){
        viewModelScope.launch {
            photoLiveData.postValue(photo)
        }
    }


}