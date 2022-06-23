package com.example.internshipproject.ui.component.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.internshipproject.databinding.FragmentPhotoDetailBinding
import com.example.internshipproject.ui.viewmodel.PhotoDetailViewModel
import com.example.internshipproject.ui.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso

class PhotoDetailFragment : Fragment() {

    private lateinit var binding: FragmentPhotoDetailBinding
    private lateinit var photoDetaiViewModel: PhotoDetailViewModel


    val bundle:PhotoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentPhotoDetailBinding.inflate(inflater,container,false)

        initViewModel()
        initArgs()


        return binding.root
    }

    private fun initViewModel(){

       // val retrofitService=RetrofitApiService.getInstance()
      //  val repo =Repository(retrofitService)

        photoDetaiViewModel=ViewModelProvider(this, ViewModelFactory()).get(PhotoDetailViewModel::class.java)

    }

    private fun initArgs() {

        binding.apply {
            Picasso.get().load(bundle.photoObj.url).into(ivPostDetail)
            tvPostDescription.text=bundle.photoObj.title
        }


    }

    /* override fun onActivityCreated(savedInstanceState: Bundle?) {
         super.onActivityCreated(savedInstanceState)
         viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
         // TODO: Use the ViewModel
     }*/

}