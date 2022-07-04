package com.example.internshipproject.view.ui.component.users

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.*
import com.example.internshipproject.api.network.RetrofitApiService
import com.example.internshipproject.api.repo.Repository
import com.example.internshipproject.databinding.FragmentUsersBinding
import com.example.internshipproject.view.adapter.UserAdapter
import com.example.internshipproject.view.ui.viewmodel.UserViewModel
import com.example.internshipproject.view.ui.viewmodel.ViewModelFactory

class UserFragment : Fragment()
{

    private lateinit var binding: FragmentUsersBinding
    private  var userAdapter= UserAdapter()
    lateinit var  userViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentUsersBinding.inflate(inflater,container,false)

        initViewModel()
        getUsers()
        initRecyclerView()

        return binding.root

    }

    private fun initRecyclerView() {
        binding.rvUsers.apply {
            adapter=userAdapter
            layoutManager=LinearLayoutManager(activity)
        }
    }

    private fun initViewModel(){
        val retrofitService= RetrofitApiService.getInstance()
        val userRepo = Repository(retrofitService)

        userViewModel= ViewModelProvider(this, ViewModelFactory(userRepo))[UserViewModel::class.java]
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun getUsers(){
        userViewModel.userListLiveData.observe(this){
            userAdapter.setUsers(it)
        }
        userViewModel.apply {
            errorMsg.observe(this@UserFragment){
            }
            loading.observe(this@UserFragment) {
                if (it) {
                    binding.progressDialog.visibility = View.VISIBLE
                } else {
                    binding.progressDialog.visibility = View.GONE
                }
            }
            getUsers()
        }
    }
}