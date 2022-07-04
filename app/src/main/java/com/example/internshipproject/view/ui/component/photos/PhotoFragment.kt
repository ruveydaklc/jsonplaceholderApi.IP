package com.example.internshipproject.view.ui.component.photos

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.internshipproject.api.network.RetrofitApiService
import com.example.internshipproject.api.repo.Repository
import com.example.internshipproject.databinding.FragmentPhotosBinding
import com.example.internshipproject.view.adapter.PhotoAdapter
import com.example.internshipproject.view.ui.viewmodel.PhotoViewModel
import com.example.internshipproject.view.ui.viewmodel.ViewModelFactory

class PhotoFragment : Fragment() {

    private lateinit var photoViewModel: PhotoViewModel
    private lateinit var binding: FragmentPhotosBinding
    private var photoAdapter= PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding=FragmentPhotosBinding.inflate(inflater,container,false)

        initViewModel()
        getPhotos()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvPost.apply {
            adapter=photoAdapter
            layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }
    private fun initViewModel(){
        val retrofitService= RetrofitApiService.getInstance()
        val userRepo = Repository(retrofitService)

        photoViewModel= ViewModelProvider(this, ViewModelFactory(userRepo))[PhotoViewModel::class.java]
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun getPhotos(){
        photoViewModel.photoListLiveData.observe(this){
            photoAdapter.setPhotos(it)
        }
        photoViewModel.apply {
            errorMsg.observe(this@PhotoFragment){

            }
            loading.observe(this@PhotoFragment) {
                if (it) {
                   binding.progressBar.visibility = View.VISIBLE
                } else {
                   binding.progressBar.visibility = View.GONE
                }
            }
            getPhotos()
        }
    }
}