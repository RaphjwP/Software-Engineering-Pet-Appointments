package com.example.meetmypetbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meetmypetbuddy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFAQ.setOnClickListener {
            var intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnScheduleHistory.setOnClickListener {
            var intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.btnScheduleAppointment.setOnClickListener {
            var intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }

        binding.btnNearbyClinic.setOnClickListener {
            var intent = Intent(this, NearbyActivity::class.java)
            startActivity(intent)
        }

        binding.btnProfile.setOnClickListener {
            var intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }
}