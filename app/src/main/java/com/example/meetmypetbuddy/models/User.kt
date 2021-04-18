package com.example.meetmypetbuddy.models

enum class Role {
    CUSTOMER, RECEPTIONIST, DOCTOR
}

// Parent Class
open class User (open var first_name: String, open var last_name: String, open var age: Int, open var role: Role, open var email:String)

// Three specialized classes for the users
data class Customer(var pets_owned: List<Pet>, override var first_name: String,
                    override var last_name: String, override var age: Int, override var role: Role, override var email: String
) : User(first_name, last_name, age, role, email)

data class Receptionist(var working_clinic: String, override var first_name: String,
                        override var last_name: String, override var age: Int, override var role: Role, override var email: String) : User(first_name, last_name, age, role, email)

data class Doctor(var working_clinic: String, var specialization: String, override var first_name: String,
                  override var last_name: String, override var age: Int, override var role: Role, override var email: String) : User(first_name, last_name, age, role, email)