package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityNearbyBinding

class NearbyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNearbyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNearbyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgClinic2.setOnClickListener {
            var intent = Intent(this, ClinicReviewActivity::class.java)
            intent.putExtra("Clinic_name", "Clinic of Oakville")
            intent.putExtra("user", "customer")
            intent.putExtra("address", "126 ABC st")
            startActivity(intent)
        }

        binding.imgClinic21.setOnClickListener {
            var intent = Intent(this, ClinicReviewActivity::class.java)
            intent.putExtra("Clinic_name", "Animal Hospital")
            intent.putExtra("user", "customer")
            intent.putExtra("address", "166 EFG st")
            startActivity(intent)
        }

        binding.imgClinic212.setOnClickListener {
            var intent = Intent(this, ClinicReviewActivity::class.java)
            intent.putExtra("Clinic_name", "Upperpet Hospital")
            intent.putExtra("user", "customer")
            intent.putExtra("address", "87 ZYQ st")
            startActivity(intent)
        }
    }
}