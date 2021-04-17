package com.example.meetmypetbuddy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityClinicHistoryBinding
import com.example.meetmypetbuddy.databinding.ActivityClinicReviewsBinding

class ClinicReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClinicReviewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityClinicReviewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}