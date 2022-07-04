package com.example.internshipproject.view.ui.component.detail

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.internshipproject.api.data.Photo
import com.example.internshipproject.databinding.FragmentPhotoDetailBinding
import com.example.internshipproject.view.ui.viewmodel.PhotoDetailViewModel
import com.example.internshipproject.view.ui.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso

class PhotoDetailFragment : Fragment() {

    private lateinit var binding: FragmentPhotoDetailBinding
    private  var photoDetaiViewModel= PhotoDetailViewModel()
    private val bundle:PhotoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentPhotoDetailBinding.inflate(inflater,container,false)

        initViewModel()
        observeLData()
        getPhotoData(bundle.photoObj)

        return binding.root
    }

    private fun getPhotoData(photo:Photo) {
        photoDetaiViewModel.initData(photo)
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun observeLData() {
        photoDetaiViewModel.photoLiveData.observe(this@PhotoDetailFragment){
            initArgs(it)
        }
    }

    private fun initViewModel(){
        photoDetaiViewModel= ViewModelProvider(this, ViewModelFactory())[PhotoDetailViewModel::class.java]
    }

    private fun initArgs(obj:Photo) {
        binding.apply {
            Picasso.get().load(obj.url).into(ivPostDetail)
            tvPostDescription.text=obj.title
        }
    }
}
