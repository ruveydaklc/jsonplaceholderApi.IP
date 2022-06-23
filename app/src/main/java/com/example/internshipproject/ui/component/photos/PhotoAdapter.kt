package com.example.internshipproject.ui.component.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipproject.api.data.Photo
import com.example.internshipproject.databinding.PhotoCardBinding

class PhotoAdapter:RecyclerView.Adapter<PhotoViewHolder>() {

    var listPhotos= mutableListOf<Photo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PhotoCardBinding.inflate(inflater,parent,false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindData(listPhotos[position])


        holder.itemView.setOnClickListener { view ->
            val actionss= PhotoFragmentDirections.actionPostsFragmentToDetailFragment(listPhotos[position])
            view.findNavController().navigate(actionss)

        }

    }

    override fun getItemCount(): Int {
        return listPhotos.size
    }
    fun setPhotos(photos:List<Photo>){
        this.listPhotos=photos.toMutableList()
        notifyDataSetChanged()
    }

}