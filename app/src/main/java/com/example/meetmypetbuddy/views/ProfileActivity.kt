package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meetmypetbuddy.R
import com.example.meetmypetbuddy.adapters.PetsAdapter
import com.example.meetmypetbuddy.adapters.ReviewsAdapter
//import com.example.meetmypetbuddy.controllers.ClinicReviewActivityController
import com.example.meetmypetbuddy.controllers.MessageController
import com.example.meetmypetbuddy.controllers.PetController
import com.example.meetmypetbuddy.databinding.ActivityProfileBinding
import com.example.meetmypetbuddy.databinding.ActivityUpcomingAppointmentsBinding
import com.example.meetmypetbuddy.models.Pet
import com.example.meetmypetbuddy.models.Review

class ProfileActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityProfileBinding

    private val vm: PetController by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
//
        Log.d("ABC", "Calling the api from the main activity!")
        vm.getPetsFromApi()

        binding.rvPets.layoutManager = LinearLayoutManager(this)

        val reviewDataChanged = Observer<List<Pet>> {
            if (!it.isNullOrEmpty()) {
                binding.rvPets.adapter = PetsAdapter(it)
            }
        }

        vm.petList.observe(this, reviewDataChanged)

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