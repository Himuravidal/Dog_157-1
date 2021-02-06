package com.example.dog_157_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dog_157_1.databinding.ImageItemBinding
import com.example.dog_157_1.model.local.ImagesBreed

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageVH>() {

    private var imageList = listOf<ImagesBreed>()

    fun update(list: List<ImagesBreed>) {
        imageList = list
        notifyDataSetChanged()
    }

    inner class ImageVH(private val binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imagesBreed: ImagesBreed) {
            Glide.with(binding.imageView)
                .load(imagesBreed.imgURL)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        return ImageVH(ImageItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        val item = imageList[position]
        holder.bind(item)
    }

    override fun getItemCount() = imageList.size
}