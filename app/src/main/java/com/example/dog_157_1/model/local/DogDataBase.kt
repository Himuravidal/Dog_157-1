package com.example.dog_157_1.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BreedEntity::class, ImagesBreed::class], version = 1)
abstract class DogDataBase : RoomDatabase() {

    abstract fun getDogDao(): DogDao

    companion object {
        private var INSTANCE : DogDataBase? = null
        fun getDataBase(context: Context): DogDataBase {
            return INSTANCE ?: synchronized(this){
                val tempInstance = Room.databaseBuilder(context.applicationContext,
                    DogDataBase::class.java,
                    "dog_db")
                    .build()
                INSTANCE = tempInstance
                tempInstance
            }
        }
    }
}