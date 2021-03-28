package com.example.meetmypetbuddy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityAddpetBinding
import com.example.meetmypetbuddy.databinding.ActivityChooseAccountBinding

class AddPetActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityAddpetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityAddpetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancelAddPet.setOnClickListener {
            var intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnSubmitAddPet.setOnClickListener {
            var intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}