package com.example.dog_157_1

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dog_157_1.model.DogRepo
import com.example.dog_157_1.model.local.BreedEntity
import com.example.dog_157_1.model.local.DogDataBase
import com.example.dog_157_1.model.local.ImagesBreed
import kotlinx.coroutines.launch

class DogViewModel(application: Application): AndroidViewModel(application){

    private val repository : DogRepo

    init {
        val dao = DogDataBase.getDataBase(application).getDogDao()
        repository = DogRepo(dao)

        viewModelScope.launch {
            Log.d("VIEWMODEL", "fetch")
            repository.fetchAllBreed()
        }
    }

    fun getBreedList(): LiveData<List<BreedEntity>> = repository.listBreed



    private var breedSelected : String = ""

    fun selectedBreed(breed: String) = viewModelScope.launch{
        breedSelected = breed
        repository.fetchImageByBreed(breed)
    }

    fun getImage(): LiveData<List<ImagesBreed>> = repository.getAllimagesByBreed(breedSelected)


}