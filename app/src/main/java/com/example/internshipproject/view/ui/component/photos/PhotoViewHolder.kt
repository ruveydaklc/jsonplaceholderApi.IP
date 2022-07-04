package com.example.internshipproject.view.ui.component.photos

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipproject.R
import com.example.internshipproject.api.data.Photo
import com.example.internshipproject.databinding.PhotoCardBinding
import com.squareup.picasso.Picasso

class PhotoViewHolder(val binding: PhotoCardBinding):RecyclerView.ViewHolder(binding.root) {

    private val image:ImageView = itemView.findViewById(R.id.ivPostCard)

    fun bindData(photo: Photo){
        Picasso.get().load(photo.url).into(image)
    }
}