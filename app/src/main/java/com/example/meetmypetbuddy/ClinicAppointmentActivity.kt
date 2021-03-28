package com.example.meetmypetbuddy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityClinicMenuBinding
import com.example.meetmypetbuddy.databinding.ActivityUpcomingAppointmentsBinding

class ClinicAppointmentActivity : AppCompatActivity(){

    private lateinit var binding: ActivityUpcomingAppointmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityUpcomingAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}