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
import com.example.meetmypetbuddy.controllers.ReviewController
import com.example.meetmypetbuddy.databinding.ActivityClinicReviewsBinding
import com.example.meetmypetbuddy.models.Review


class ClinicReviewActivity : AppCompatActivity() {

    private val vm: ReviewController by viewModels()

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
                getRatingAverage()
            }
        }

        vm.reviewList.observe(this, reviewDataChanged)

        // Set view
        val clinicName: String = intent.getStringExtra("Clinic_name").toString()
        binding.clinicName.text = clinicName
        val address: String = intent.getStringExtra("address").toString()
        binding.clinicAddress.text = address
        val doctorName = "Dr. Soft"

        binding.btnWriteReview.setOnClickListener {
            var intent = Intent(this, WriteReviewActivity::class.java)
            intent.putExtra("clinic_name", clinicName)
            intent.putExtra("doctor_name", doctorName)
            startActivity(intent)
        }

    }

    fun getRatingAverage() {
        var ratingReviews: List<Review>? = vm.reviewList.value
        var rating_avg: Float = 0F
        Log.d("ABC", "To test rating review list")
        Log.d("ABC", ratingReviews.toString())
        var counter: Int = 0
        if (ratingReviews != null) {
            ratingReviews.forEach {
                counter += 1
                rating_avg += it.rating
            }
            rating_avg = rating_avg / counter
        }

        binding.reviewRatingBar.rating = rating_avg
        binding.ratingNumber.text = rating_avg.toString()
    }

}