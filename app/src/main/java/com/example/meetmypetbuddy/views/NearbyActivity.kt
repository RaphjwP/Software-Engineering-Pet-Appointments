package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.controllers.ClinicReviewActivityController
import com.example.meetmypetbuddy.databinding.ActivityNearbyBinding

class NearbyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNearbyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNearbyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgClinic2.setOnClickListener {
            var intent = Intent(this, ClinicReviewActivity::class.java)
            intent.putExtra("Clinic_name", "Animal Hospital of Oakville")
            intent.putExtra("user", "customer")
            startActivity(intent)
        }
    }
}