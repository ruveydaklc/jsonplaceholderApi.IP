package com.example.internshipproject.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshipproject.api.data.User
import kotlinx.coroutines.launch

class UserDetailViewModel : ViewModel() {

    val userLiveData: MutableLiveData<User> = MutableLiveData()

    fun initData(user: User){
        viewModelScope.launch {
            userLiveData.postValue(user)
        }
    }


}