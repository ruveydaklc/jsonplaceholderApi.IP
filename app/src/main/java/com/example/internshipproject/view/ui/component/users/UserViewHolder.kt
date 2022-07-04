package com.example.internshipproject.view.ui.component.users

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipproject.R
import com.example.internshipproject.api.data.User
import com.example.internshipproject.databinding.UserCardBinding


class UserViewHolder(binding: UserCardBinding):RecyclerView.ViewHolder(binding.root) {

    val name:TextView = itemView.findViewById(R.id.tvNameC)
    private val sName:TextView = itemView.findViewById(R.id.tvSurnameC)
    private val email:TextView = itemView.findViewById(R.id.tvEmailC)

    @SuppressLint("SetTextI18n")
    fun bindData(user : User){
        name.text  = "Name     : ${user.name}"
        sName.text = "Username : ${user.username}"
        email.text = "Email    : ${user.email}"

        /*itemView.setOnClickListener { view->
            val action=UserFragmentDirections.actionUserFragmentToDetailFragment(user.id)
            view.findNavController().navigate(action)
        }*/
    }
}

