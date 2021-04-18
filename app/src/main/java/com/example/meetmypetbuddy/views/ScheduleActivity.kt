package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityScheduleBinding

class ScheduleActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancelAppointment.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // This button should go to Submit
        // Create a session and add it
        binding.btnScheduleSubmit.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}