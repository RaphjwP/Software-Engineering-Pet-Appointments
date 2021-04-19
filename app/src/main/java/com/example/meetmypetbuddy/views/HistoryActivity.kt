package com.example.meetmypetbuddy.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meetmypetbuddy.adapters.AppointmentsAdapter
import com.example.meetmypetbuddy.controllers.AppointmentController
import com.example.meetmypetbuddy.databinding.ActivityHistoryBinding
import com.example.meetmypetbuddy.models.Appointment

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private val vm: AppointmentController by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("ABC", "Calling the api from the main activity!")
        vm.getUserAppointments("Vladik");

        binding.rvPets.layoutManager = LinearLayoutManager(this)

        val appointmentDataChanged = Observer<List<Appointment>> {
            if (!it.isNullOrEmpty()) {
                binding.rvPets.adapter = AppointmentsAdapter(it)
            }
        }

        vm.appointmentList.observe(this, appointmentDataChanged)

    }
}