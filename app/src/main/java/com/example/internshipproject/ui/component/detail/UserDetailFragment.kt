package com.example.internshipproject.ui.component.detail

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.internshipproject.databinding.FragmentUserDetailBinding
import com.example.internshipproject.ui.viewmodel.UserDetailViewModel
import com.example.internshipproject.ui.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso

class UserDetailFragment : Fragment() {

    lateinit var binding: FragmentUserDetailBinding
    private lateinit var userDetailViewModel: UserDetailViewModel

    val bundle:UserDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentUserDetailBinding.inflate(layoutInflater,container,false)

        initViewModel()
        initArgs()

        return binding.root
    }

    private fun initViewModel(){

        //val retrofitService= RetrofitApiService.getInstance()
        //val repo = Repository(retrofitService)

        userDetailViewModel=ViewModelProvider(this, ViewModelFactory()).get(UserDetailViewModel::class.java)

    }

    @SuppressLint("SetTextI18n")
    private fun initArgs() {
        val obj =bundle.userObj
        binding.apply {
            tvDescriptionUD.text= obj.username + "\n"+ obj.name+ "\n"+  obj.email + "\n"+ obj.website  + "\n"+ obj.address + "\n"+ obj.phone
        }


    }

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userDetailViewModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}