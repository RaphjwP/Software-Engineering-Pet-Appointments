package com.example.meetmypetbuddy.views

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meetmypetbuddy.R
import com.example.meetmypetbuddy.adapters.ReviewsAdapter
import com.example.meetmypetbuddy.controllers.ClinicReviewActivityController
import com.example.meetmypetbuddy.databinding.ActivityClinicReviewsBinding
import com.example.meetmypetbuddy.models.Review

class ClinicReviewActivity : AppCompatActivity() {

    private val vm: ClinicReviewActivityController by viewModels()

    private lateinit var binding: ActivityClinicReviewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_clinic_reviews)

        Log.d("ABC", "Calling the api from the main activity!")
        vm.fetchReviewFromAPI()

        binding.rvReview.layoutManager = LinearLayoutManager(this)

        val reviewDataChanged = Observer<List<Review>> {
            // if the list of data is NOT null, then populate the adapter
            if (!it.isNullOrEmpty()) {
                binding.rvReview.adapter = ReviewsAdapter(it)
            }
        }

        vm.reviewList.observe(this, reviewDataChanged)

    }

}