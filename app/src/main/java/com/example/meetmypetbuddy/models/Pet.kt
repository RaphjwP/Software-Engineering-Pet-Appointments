package com.example.meetmypetbuddy.models

data class Pet (val pet_name:String, val pet_age:Int, val pet_type:String, val pet_breed:String,  val assigned_vet:String, val clinic_name: String){
    val pet_age_string = pet_age.toString()
}