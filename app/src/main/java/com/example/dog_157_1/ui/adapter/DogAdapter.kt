package com.example.dog_157_1.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.dog_157_1.databinding.BreedItemBinding
import com.example.dog_157_1.model.local.BreedEntity

class DogAdapter : RecyclerView.Adapter<DogAdapter.DogBreedVH>() {

    private var listBreed = listOf<BreedEntity>()
    private val selectedBreed = MutableLiveData<BreedEntity>()

    fun updateBreed(list: List<BreedEntity>){
        listBreed = list
        notifyDataSetChanged()
    }

    fun selectedItem(): LiveData<BreedEntity> = selectedBreed

    inner class DogBreedVH(private val binding : BreedItemBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(breedEntity: BreedEntity) {
            binding.tvBreed.text = breedEntity.breed
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedBreed.value = listBreed[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogBreedVH {
        return DogBreedVH(BreedItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DogBreedVH, position: Int) {
        val breed = listBreed[position]
        holder.bind(breed)
    }

    override fun getItemCount() = listBreed.size

}