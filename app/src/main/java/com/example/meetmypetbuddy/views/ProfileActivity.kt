package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddPet.setOnClickListener {
            var intent = Intent(this, AddPetActivity::class.java)
            startActivity(intent)
        }

        binding.btnViewHistory.setOnClickListener {
            var intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}