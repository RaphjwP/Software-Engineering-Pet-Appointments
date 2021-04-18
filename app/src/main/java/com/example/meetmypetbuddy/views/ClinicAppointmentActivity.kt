package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meetmypetbuddy.R
import com.example.meetmypetbuddy.adapters.ReviewsAdapter
import com.example.meetmypetbuddy.controllers.AppointmentController
import com.example.meetmypetbuddy.controllers.ClinicReviewActivityController
import com.example.meetmypetbuddy.databinding.ActivityClinicMenuBinding
import com.example.meetmypetbuddy.databinding.ActivityUpcomingAppointmentsBinding
import com.example.meetmypetbuddy.models.Review
import androidx.lifecycle.Observer
import com.example.meetmypetbuddy.adapters.AppointmentsAdapter
import com.example.meetmypetbuddy.models.Appointment

class ClinicAppointmentActivity : AppCompatActivity(){
    private val vm: AppointmentController by viewModels()
    private lateinit var binding: ActivityUpcomingAppointmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityUpcomingAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Log.d("ABC", "Calling the api from the main activity!")
        vm.getClinicAppointment("Lera's Hospitality");

        binding.rvReview.layoutManager = LinearLayoutManager(this)

        val appointmentDataChanged = Observer<List<Appointment>> {
            if (!it.isNullOrEmpty()) {
                binding.rvReview.adapter = AppointmentsAdapter(it)
            }
        }

        vm.appointmentList.observe(this, appointmentDataChanged)
    }
}