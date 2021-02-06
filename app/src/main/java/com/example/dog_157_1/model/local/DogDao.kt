package com.example.dog_157_1.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDogBreed(breedList: List<BreedEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImagesDog(breedImagesBreed: List<ImagesBreed>)

    @Query("SELECT * FROM breed_table")
    fun getAllBreedList(): LiveData<List<BreedEntity>>

    @Query("SELECT * FROM image_table WHERE breed = :breed")
    fun getImagesByBreed(breed: String): LiveData<List<ImagesBreed>>

}