package com.example.meetmypetbuddy.controllers

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meetmypetbuddy.models.Review
import com.example.meetmypetbuddy.networkService.ReviewApi
import kotlinx.coroutines.launch

class ClinicReviewActivityController : ViewModel(){
    var reviewList = MutableLiveData<List<Review>>()

    fun fetchReviewFromAPI(){
        viewModelScope.launch {
            try {
                val response = ReviewApi.retrofitService.getReviews()
                if (response.isSuccessful && response.body() != null) {
                    Log.d(TAG, "I got a response from the API")
                    Log.d(TAG, response.body()!!.toString())
                    reviewList.value = response.body()!!
                }
                else {
                    Log.d(TAG, "Error occured when getting the response from the API")
                }
            }
            catch(e:Exception) {
                Log.d(TAG, "Error: ${e.message}")
            }
        }
    }
}