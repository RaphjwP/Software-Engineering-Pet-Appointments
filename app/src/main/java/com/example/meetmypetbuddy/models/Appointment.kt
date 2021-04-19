package com.example.meetmypetbuddy.models

import java.util.*

data class Appointment(val owner_name: String,
                       val pet_type: String,
                       val doctor_name: String,
                       val clinic_name: String,
                       val clinic_address: String,
                       val date: String){}