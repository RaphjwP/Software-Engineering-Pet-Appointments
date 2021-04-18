package com.example.meetmypetbuddy.models

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Review(var written_by:String, var review_description: String, var clinic_name:String, var doctor_name:String, var date: String, var rating: Int, var feedback_given:String){
//    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//    var date_string = date.format(formatter)
}