package com.example.internshipproject.view.ui.component.detail

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.internshipproject.api.data.User
import com.example.internshipproject.databinding.FragmentUserDetailBinding
import com.example.internshipproject.view.ui.viewmodel.UserDetailViewModel
import com.example.internshipproject.view.ui.viewmodel.ViewModelFactory

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
        observeLiveData()
        getUserData(bundle.userObj)

        return binding.root
    }

    private fun getUserData(user: User) {
        userDetailViewModel.initData(user)
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun observeLiveData() {
        userDetailViewModel.userLiveData.observe(this@UserDetailFragment){
            initArgs(it)
        }
    }

    private fun initViewModel(){
        userDetailViewModel=ViewModelProvider(this, ViewModelFactory()).get(UserDetailViewModel::class.java)
    }


    @SuppressLint("SetTextI18n")
    private fun initArgs(obj:User) {
        binding.apply {
            tvDescriptionUD.text=  obj.name+ "\n"+ obj.username + "\n"+ obj.email + "\n"+ obj.website  + "\n"+ obj.address + "\n"+ obj.phone
        }
    }



}