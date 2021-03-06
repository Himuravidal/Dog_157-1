package com.example.dog_157_1.model.remote

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://dog.ceo/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


object DogApi {
    val retrofitService : DogAPI by lazy {
        retrofit.create(DogAPI::class.java)
    }
}