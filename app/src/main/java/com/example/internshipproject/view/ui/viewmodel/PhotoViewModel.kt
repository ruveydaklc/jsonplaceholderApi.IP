package com.example.internshipproject.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.internshipproject.api.data.Photo
import com.example.internshipproject.api.repo.Repository
import kotlinx.coroutines.*

class PhotoViewModel  (private val repo: Repository)  : ViewModel() {
    val photoListLiveData= MutableLiveData<List<Photo>>()

    val errorMsg= MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    var handleJob: Job?=null

    private val exceptionHandler= CoroutineExceptionHandler { _, throwable ->onError(
        "Exception: ${throwable.localizedMessage}")
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
        handleJob= CoroutineScope(Dispatchers.Main+exceptionHandler).launch {
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