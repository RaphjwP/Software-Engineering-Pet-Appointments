package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityFaqBinding
import com.example.meetmypetbuddy.databinding.ActivityHistoryBinding

class FAQActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}