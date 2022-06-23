package com.example.internshipproject.ui.component.photos

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipproject.R
import com.example.internshipproject.api.data.Photo
import com.example.internshipproject.databinding.PhotoCardBinding
import com.squareup.picasso.Picasso

class PhotoViewHolder(val binding: PhotoCardBinding):RecyclerView.ViewHolder(binding.root) {

    val image:ImageView

    init {
        image=itemView.findViewById(R.id.ivPostCard)
    }

    fun bindData(photo: Photo){
        Picasso.get().load(photo.url).into(image)
    }

}