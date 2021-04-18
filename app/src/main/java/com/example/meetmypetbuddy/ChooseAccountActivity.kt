package com.example.meetmypetbuddy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityChooseAccountBinding


class ChooseAccountActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityChooseAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityChooseAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClinicAccount.setOnClickListener {
            var intent = Intent(this, ClinicMenuActivity::class.java)
            startActivity(intent)
        }

        binding.btnOwnerAccount.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}