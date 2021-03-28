package com.example.meetmypetbuddy

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

    }
}