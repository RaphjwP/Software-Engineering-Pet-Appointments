package com.example.meetmypetbuddy.controllers

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Review
import com.example.meetmypetbuddy.networkService.Api
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class ClinicReviewActivityController : ViewModel(){
    var reviewList = MutableLiveData<List<Review>>()

    fun fetchReviewFromAPI(){
        Log.d("ABC", "fetchReviewFromAPI called")
        viewModelScope.launch {
            try {
                val response = Api.retrofitService.getReviews()
                if (response.isSuccessful && response.body() != null) {
                    Log.d("ABC", "I got a response from the API")
                    Log.d("ABC", response.body()!!.toString())
                    reviewList.value = response.body()
                }
                else {
                    Log.d("ABC", "Error occured when getting the response from the API")
                }
            }
            catch(e:Exception) {
                Log.d("ABC", "Error: ${e.message}")
            }
        }
    }

    fun postReviewToAPI(review: Review){
        val jsonObject = JSONObject()
        jsonObject.put("written_by", review.written_by)
        jsonObject.put("review_description", review.review_description)
        jsonObject.put("clinic_name", review.clinic_name)
        jsonObject.put("doctor_name", review.doctor_name)
        jsonObject.put("date", review.date)
        jsonObject.put("rating", review.rating)
        jsonObject.put("feedback_given", review.feedback_given)

        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        viewModelScope.launch {
            try{
                val response = Api.retrofitService.insertReview(requestBody);
                Log.d("RPT", response.toString());
            }catch (e:Exception){
                Log.d("RPT", e.toString());
            }
        }
    }

}