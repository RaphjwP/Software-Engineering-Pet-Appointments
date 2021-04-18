package com.example.meetmypetbuddy.controllers

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Review
import com.example.meetmypetbuddy.networkService.Api
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.*

class AppointmentController : ViewModel() {

    var appointmentList = MutableLiveData<List<Appointment>>()

    fun placeAnAppointment(appointment: Appointment){

        val jsonObject = JSONObject()
        jsonObject.put("owner_name", appointment.owner_name)
        jsonObject.put("pet_type", appointment.pet_type)
        jsonObject.put("doctor_name", appointment.doctor_name)
        jsonObject.put("clinic_name", appointment.clinic_name)
        jsonObject.put("clinic_address", appointment.clinic_address)
        jsonObject.put("date", appointment.date)

        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        viewModelScope.launch {
            try{
                val response = Api.retrofitService.placeAnAppointment(requestBody);
                Log.d("RES", response.toString());
            }catch (e:Exception){
                Log.d("RES", e.toString());
            }
        }
    }

    fun getAllAppointments() {
        Log.d("ABC", "fetchReviewFromAPI called")
        viewModelScope.launch {
            try {
                val response = Api.retrofitService.getAppointments()
                if (response.isSuccessful && response.body() != null) {
                    Log.d("ABC", "I got a response from the API")
                    Log.d("ABC", response.body()!!.toString())
                    appointmentList.value = response.body()!!
                } else {
                    Log.d("ABC", "Error occured when getting the response from the API")
                }
            } catch (e: Exception) {
                Log.d("ABC", "Error: ${e.message}")
            }
        }
    }


    fun getUserAppointments(name: String) {
        viewModelScope.launch {
            try {
                val response = Api.retrofitService.getUserAppointments(name);
                appointmentList.value = response.body()!!
            } catch (e: Exception) {
                Log.d("ABC", "Error: ${e.message}")
            }
        }
    }

}