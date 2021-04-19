package com.example.meetmypetbuddy.controllers

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meetmypetbuddy.models.Message
import com.example.meetmypetbuddy.models.Pet
import com.example.meetmypetbuddy.networkService.Api
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class PetController : ViewModel(){
    var petList = MutableLiveData<List<Pet>>()

    fun getPetsFromApi(){
        Log.d("ABC", "fetchReviewFromAPI called")
        viewModelScope.launch {
            try {
                val response = Api.retrofitService.getPets()
                if (response.isSuccessful && response.body() != null) {
                    Log.d("ABC", "I got a response from the API")
                    Log.d("ABC", response.body()!!.toString())
                    petList.value = response.body()
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

    fun insertNewPet(pet: Pet){
        val jsonObject = JSONObject()
        jsonObject.put("name", pet.name)
        jsonObject.put("age", pet.age)
        jsonObject.put("type", pet.type)
        jsonObject.put("gender", pet.gender)
        jsonObject.put("breed", pet.breed)
        jsonObject.put("animal_clinic", pet.animal_clinic)
        jsonObject.put("assigned_vet", pet.assigned_vet)

        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        viewModelScope.launch {
            try{
                val response = Api.retrofitService.insertNewPet(requestBody);
                Log.d("RPT", response.toString());
            }catch (e:Exception){
                Log.d("RPT", e.toString());
            }
        }
    }

}