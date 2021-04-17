package com.example.meetmypetbuddy.models

import java.time.LocalDate

data class Review(var written_by:String, var review_description: String, var clinic_name:String, var doctor_name:String, var date: LocalDate, var rating: Int, var feedback_given:String)