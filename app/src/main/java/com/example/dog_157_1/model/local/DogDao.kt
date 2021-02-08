package com.example.dog_157_1.model.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDogBreed(breedList: List<BreedEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllImagesDog(breedImagesBreed: List<ImagesBreed>)

    @Query("SELECT * FROM breed_table")
    fun getAllBreedList(): LiveData<List<BreedEntity>>

    @Query("SELECT * FROM image_table WHERE breed = :breed")
    fun getImagesByBreed(breed: String): LiveData<List<ImagesBreed>>

    //fav Example
    @Update
    suspend fun updateImageBreed(imagesBreed: ImagesBreed)

    @Query("SELECT * FROM image_table WHERE fav = 1")
    fun getAllFavImages(): LiveData<List<ImagesBreed>>


}