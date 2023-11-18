package com.example.dogbreed.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DogImageResponse(
    @Json(name = "message")
    val message: List<String>,
    @Json(name = "status")
    val status: String
)