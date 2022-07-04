package com.example.internshipproject.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.internshipproject.api.data.User
import com.example.internshipproject.api.repo.Repository
import kotlinx.coroutines.*

 class UserViewModel ( val userRepo: Repository) : ViewModel(){

    val userListLiveData= MutableLiveData<List<User>>()

    val errorMsg=MutableLiveData<String>()
    var handleJob:Job?=null

    val loading =MutableLiveData<Boolean>()

    val exceptionHandler= CoroutineExceptionHandler { _,throwable ->onError(
        "Exception: ${throwable.localizedMessage}"
    )

    }



    private fun onError(msg:String){
        errorMsg.value=msg
        loading.value=false
    }

    override fun onCleared() {
        super.onCleared()
        handleJob?.cancel()
    }

    fun getUsers(){
        handleJob= CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response= userRepo.getUsers()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    userListLiveData.postValue(response.body())
                    loading.value=false
                }else{
                    onError("Error! ${response.message()}")
                }
            }
        }
    }

}