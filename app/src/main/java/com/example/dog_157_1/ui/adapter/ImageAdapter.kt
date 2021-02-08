package com.example.dog_157_1.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dog_157_1.databinding.ImageItemBinding
import com.example.dog_157_1.model.local.BreedEntity
import com.example.dog_157_1.model.local.ImagesBreed

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageVH>() {

    private var imageList = listOf<ImagesBreed>()

    private var selectedItem = MutableLiveData<ImagesBreed>()
    fun selectedItem() = selectedItem

    fun update(list: List<ImagesBreed>) {
        imageList = list
        notifyDataSetChanged()
    }

    inner class ImageVH(private val binding: ImageItemBinding):
        RecyclerView.ViewHolder(binding.root), View.OnLongClickListener {
        fun bind(imagesBreed: ImagesBreed) {
            Glide.with(binding.imageView)
                .load(imagesBreed.imgURL)
                .into(binding.imageView)
            if (imagesBreed.fav) {
                binding.ivfav.setColorFilter(Color.RED)
            } else{
                binding.ivfav.setColorFilter(Color.BLACK)
            }
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            selectedItem.value = imageList[adapterPosition]
           return true
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