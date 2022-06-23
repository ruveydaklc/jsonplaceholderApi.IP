package com.example.internshipproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.internshipproject.api.data.Photo
import com.example.internshipproject.api.repo.Repository
import kotlinx.coroutines.*

class PhotoViewModel  constructor(private val repo: Repository)  : ViewModel() {
    val photoListLiveData= MutableLiveData<List<Photo>>()

    val errorMsg= MutableLiveData<String>()
    var handleJob: Job?=null

    val loading = MutableLiveData<Boolean>()

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


    fun getPhotos(){

        handleJob= CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response= repo.getPhotos()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    photoListLiveData.postValue(response.body())
                    loading.value=false

                }else{
                    onError("Error! ${response.message()}")
                }
            }

        }

    }
}