package com.example.internshipproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.internshipproject.api.repo.Repository

class ViewModelFactory constructor(val repo: Repository?=null):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(UserViewModel::class.java))
        {
            UserViewModel(repo!!) as T
        }else if (modelClass.isAssignableFrom(PhotoViewModel::class.java))
        {
            PhotoViewModel(repo!!) as T
        }else if (modelClass.isAssignableFrom(PhotoDetailViewModel::class.java))
        {
            PhotoDetailViewModel() as T
        }else if (modelClass.isAssignableFrom(UserDetailViewModel::class.java))
        {
            UserDetailViewModel() as T
        }
        else{
            throw IllegalAccessException("!!View Model Not Found")
        }
    }


}