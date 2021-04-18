package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.R
import com.example.meetmypetbuddy.databinding.ActivityAddpetBinding

class AddPetActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityAddpetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityAddpetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner: Spinner = binding.typeSpinner

        ArrayAdapter.createFromResource(
                this,
                R.array.type_array,
                android. R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner.adapter = adapter
        }


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