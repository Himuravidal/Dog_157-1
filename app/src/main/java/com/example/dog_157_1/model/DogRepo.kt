package com.example.dog_157_1.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.dog_157_1.model.local.DogDao
import com.example.dog_157_1.model.local.ImagesBreed
import com.example.dog_157_1.model.remote.DogApi
import com.example.dog_157_1.model.remote.fromRemoteToEntityBreed
import com.example.dog_157_1.model.remote.fromRemoteToEntityImage
import java.lang.Exception


class DogRepo(private val dao: DogDao) {

    val listBreed  = dao.getAllBreedList() // All breed from DB

    suspend fun fetchAllBreed() { // this will fetch the data & save it on DB
            try {
                val response =  DogApi.retrofitService.fetchBreedList()
                when(response.isSuccessful){
                    true -> response.body()?.let {
                        Log.d("REPO", "$it.message")
                        dao.insertAllDogBreed(fromRemoteToEntityBreed(it))
                    }
                    false ->  Log.d("REPO", "${response.code()} - ${response.errorBody()}")
                }

            } catch (e: Exception) {
                Log.e("REPO", "${e.message}")
            }
    }

    suspend fun fetchImageByBreed(breed: String) { //this will
        try {
            val service = DogApi.retrofitService.fetchImagesByBreed(breed)
            service.body()?.let {
                dao.insertAllImagesDog(fromRemoteToEntityImage(it, breed))
            }
        } catch (e: Exception) {
            Log.e("REPO", "${e.message}")
        }
    }

    fun getAllimagesByBreed(breed: String): LiveData<List<ImagesBreed>>{
        return dao.getImagesByBreed(breed)
    }

}