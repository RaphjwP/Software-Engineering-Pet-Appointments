package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meetmypetbuddy.R
import com.example.meetmypetbuddy.controllers.PetController
import com.example.meetmypetbuddy.databinding.ActivityAddpetBinding
import com.example.meetmypetbuddy.models.Pet

class AddPetActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityAddpetBinding

    private val vm: PetController by viewModels()

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

            val petName = binding.editTextPersonName.text.toString()
            var petAge = binding.editTextNumber.text.toString()
            val petBreed = binding.editTextBreedName.text.toString()
            val assignedVet = "Dr. Klein"
            val clinic_name = "Sheridan Hospital"
            val petType = binding.typeSpinner.selectedItem.toString()

            val pet : Pet = Pet(petName, petAge.toInt(), petType, petBreed, assignedVet, clinic_name)

            vm.insertNewPet(pet)

            var intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}