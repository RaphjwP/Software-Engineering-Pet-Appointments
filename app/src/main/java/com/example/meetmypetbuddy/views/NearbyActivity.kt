package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityChooseAccountBinding
import com.example.meetmypetbuddy.databinding.ActivityNearbyBinding

class NearbyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNearbyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNearbyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgClinic1.setOnClickListener {
            var intent = Intent(this, ClinicReviewActivity::class.java)
            intent.putExtra("Clinic_name", "Animal Hospital of Oakville")
            intent.putExtra("user", "customer")
            startActivity(intent)
        }
    }


}