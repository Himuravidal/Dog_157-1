package com.example.dog_157_1.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breed_table")
data class BreedEntity(@PrimaryKey val breed: String)

