package com.example.internshipproject.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipproject.api.data.User
import com.example.internshipproject.databinding.UserCardBinding
import com.example.internshipproject.view.ui.component.users.UserFragmentDirections
import com.example.internshipproject.view.ui.component.users.UserViewHolder

class UserAdapter():RecyclerView.Adapter<UserViewHolder>() {

    var listUsers= mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val binding = UserCardBinding.inflate(inflater,parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(listUsers[position])
        holder.itemView.setOnClickListener { view ->
            val action=
                UserFragmentDirections.actionUserFragmentToUserDetailFragment(listUsers[position])
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(users:List<User>){
        this.listUsers=users.toMutableList()
        notifyDataSetChanged()
    }
}