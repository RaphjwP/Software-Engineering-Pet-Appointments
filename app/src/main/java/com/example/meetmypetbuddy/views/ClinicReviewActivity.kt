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
            if (!it.isNullOrEmpty()) {
                binding.rvReview.adapter = ReviewsAdapter(it)
            }
        }

        vm.reviewList.observe(this, reviewDataChanged)

        //Calculate rating average
        getRatingAverage()

        // Set view
        val clinicName: String = intent.getStringExtra("Clinic_name").toString()
        binding.clinicName.text = clinicName
        val address: String = intent.getStringExtra("address").toString()
        binding.clinicAddress.text = address
        val doctorName = "Dr. Soft"

        binding.btnWriteReview.setOnClickListener {
            var intent = Intent(this, WriteReviewActivity::class.java)
            intent.putExtra("Clinic_name", clinicName)
            intent.putExtra("doctor_name", doctorName)
            startActivity(intent)
        }

    }

    fun getRatingAverage() {
        var ratingReviews: List<Review>? = vm.reviewList.value
        var rating_avg: Float = 0F
        var counter: Int = 0
        if (ratingReviews != null) {
            ratingReviews.forEach {
                counter += 1
                rating_avg += it.rating
            }
        }

        binding.reviewRatingBar.rating = rating_avg
        binding.ratingNumber.text = rating_avg.toString()
    }

}