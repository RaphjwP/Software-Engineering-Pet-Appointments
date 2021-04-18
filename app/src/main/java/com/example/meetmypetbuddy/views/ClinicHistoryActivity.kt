package com.example.meetmypetbuddy.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityClinicHistoryBinding
import com.example.meetmypetbuddy.databinding.ActivityClinicMenuBinding
import com.example.meetmypetbuddy.databinding.ActivityUpcomingAppointmentsBinding

class ClinicHistoryActivity : AppCompatActivity(){

    private lateinit var binding: ActivityClinicHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityClinicHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}