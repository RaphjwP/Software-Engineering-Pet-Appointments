package com.example.meetmypetbuddy.controllers

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Message
import com.example.meetmypetbuddy.models.Review
import com.example.meetmypetbuddy.networkService.Api
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class MessageController : ViewModel(){
    var messageList = MutableLiveData<List<Message>>()

    fun getMessagesFromApi(pet_name:String){
        Log.d("ABC", "fetchReviewFromAPI called")
        viewModelScope.launch {
            try {
                val response = Api.retrofitService.getMessagePet(pet_name)
                if (response.isSuccessful && response.body() != null) {
                    Log.d("ABC", "I got a response from the API")
                    Log.d("ABC", response.body()!!.toString())
                    messageList.value = response.body()
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

    fun writeMessageToAPI(message: Message){
        val jsonObject = JSONObject()
        jsonObject.put("pet", message.pet)
        jsonObject.put("note", message.note)
        jsonObject.put("date", message.date)

        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        viewModelScope.launch {
            try{
                val response = Api.retrofitService.insertMessage(requestBody);
                Log.d("RPT", response.toString());
            }catch (e:Exception){
                Log.d("RPT", e.toString());
            }
        }
    }

}