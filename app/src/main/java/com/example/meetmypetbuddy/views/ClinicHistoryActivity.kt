package com.example.meetmypetbuddy.views

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meetmypetbuddy.adapters.AppointmentsAdapter
import com.example.meetmypetbuddy.controllers.AppointmentController
import com.example.meetmypetbuddy.databinding.ActivityClinicHistoryBinding
import com.example.meetmypetbuddy.databinding.ActivityClinicMenuBinding
import com.example.meetmypetbuddy.databinding.ActivityUpcomingAppointmentsBinding
import com.example.meetmypetbuddy.models.Appointment

class ClinicHistoryActivity : AppCompatActivity(){

    private lateinit var binding: ActivityClinicHistoryBinding
    private val vm: AppointmentController by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityClinicHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("ABC", "Calling the api from the main activity!")
        vm.getClinicAppointment("Lera's Hospitality");

        binding.rvPets.layoutManager = LinearLayoutManager(this)

        val appointmentDataChanged = Observer<List<Appointment>> {
            if (!it.isNullOrEmpty()) {
                binding.rvPets.adapter = AppointmentsAdapter(it)
            }
        }

        vm.appointmentList.observe(this, appointmentDataChanged)

    }
}