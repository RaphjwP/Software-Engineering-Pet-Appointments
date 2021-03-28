package com.example.meetmypetbuddy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityChooseAccountBinding
import com.example.meetmypetbuddy.databinding.ActivityClinicMenuBinding
import com.example.meetmypetbuddy.databinding.ActivityHistoryBinding

class ClinicMenuActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityClinicMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityClinicMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClinicHistory.setOnClickListener {
            var intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }

        binding.btnClinicUpcoming.setOnClickListener {
            var intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }

        binding.btnMyClinic.setOnClickListener {
            var intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }


    }
}