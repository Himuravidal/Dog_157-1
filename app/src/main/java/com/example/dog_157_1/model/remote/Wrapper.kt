package com.example.dog_157_1.model.remote

import com.google.gson.annotations.SerializedName

data class WrapperBreed(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String)

data class WrapperImage(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String)