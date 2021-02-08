package com.example.dog_157_1.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class ImagesBreed(@PrimaryKey val imgURL : String, val breed: String, var fav: Boolean)
