package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.controllers.AppointmentController
import com.example.meetmypetbuddy.databinding.ActivityScheduleBinding
import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Pet
import com.example.meetmypetbuddy.models.UserTest
import java.util.*

class ScheduleActivity : AppCompatActivity()  {
    private val vm: AppointmentController by viewModels()
    private lateinit var binding: ActivityScheduleBinding
    val calendar = Calendar.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding variable
        this.binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // pick month of the year, year and day from calendar
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
        }

        // set hours and minutes from spinner
        binding.spinner.setOnTimeChangedListener { view, hourOfDay, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay - 4)
            calendar.set(Calendar.MINUTE, minute)
        }

        // functionality of cancel button
        binding.btnCancelAppointment.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // functionality of the submit button
        binding.btnScheduleSubmit.setOnClickListener {
            //test user and pet
            val user = UserTest()
            val pet = Pet("Murzik", 2, "Cat", "Siamese", "Lera's Hospitality", "Dr. Lera")

            val appointment = Appointment(user.name, pet.pet_type, pet.assigned_vet, pet.clinic_name, "Trafalgar St. 124", calendar.time.toString());
            vm.placeAnAppointment(appointment)

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}