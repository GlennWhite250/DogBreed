package com.example.dogbreed.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreed.model.network.ApiClient
import com.example.dogbreed.model.response.DogImageResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel: ViewModel() {
    private var _message = mutableStateOf("")
    val message = _message

    private val _dogPic: MutableStateFlow<List<String>> = MutableStateFlow(listOf())
    val dogPic: StateFlow<List<String>> = _dogPic

//    private val _message: MutableStateFlow<String> = MutableStateFlow(" ")
//    val message: StateFlow<String> = _message
//
//    var dogPic by mutableStateOf<String?>(value = null)
//        private set
//
    fun updateSearchQuery(breed: String){
        _message.value = breed
    }
//
//    fun selectedDog(dog: String){
//        viewModelScope.launch {
//            dogPic = dog
//        }
//    }

    fun searchHero(breed: String){
        //Log.i("Glenn1", "What we are looking for is: $breed")
        viewModelScope.launch {
            ApiClient.apiService.fetchDog(breed).enqueue(object : Callback<DogImageResponse>{
                override fun onResponse(
                    call: Call<DogImageResponse>,
                    response: Response<DogImageResponse>
                ) {
                    val responseData: List<String>? = response.body()?.message
                    //Log.i("Glenn1", "The response is: $responseData")
                    if (responseData != null) {
                        _dogPic.value = responseData
                        Log.i("Glenn2", "The response is: ${_dogPic.value}")
                    } else {
                        Log.d("MyViewModel", "The responseData was null")
                    }
                }

                override fun onFailure(call: Call<DogImageResponse>, t: Throwable) {
                    Log.e("ViewModel", " ${t.message}")
                }

            })
        }
    }
}