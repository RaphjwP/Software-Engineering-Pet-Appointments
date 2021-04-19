package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meetmypetbuddy.R
import com.example.meetmypetbuddy.adapters.ReviewsAdapter
import com.example.meetmypetbuddy.controllers.ReviewController
import com.example.meetmypetbuddy.databinding.ActivityClinicFeedbackBinding
import com.example.meetmypetbuddy.databinding.ActivityClinicReviewsBinding
import com.example.meetmypetbuddy.models.Review

class ClinicFeedbackActivity : AppCompatActivity() {

    private val vm: ReviewController by viewModels()

    private lateinit var binding: ActivityClinicFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_clinic_feedback)

        Log.d("ABC", "Calling the api from the main activity in Feedbacks")
        vm.fetchReviewFromAPI()

        binding.rvReview.layoutManager = LinearLayoutManager(this)

        val reviewDataChanged = Observer<List<Review>> {
            if (!it.isNullOrEmpty()) {
                binding.rvReview.adapter = ReviewsAdapter(it)
            }
        }
        vm.reviewList.observe(this, reviewDataChanged)

    }

//    val itemOnClick: (View, Int, Int) -> Unit = { view, position, type ->
//        Log.d("TAG", "test")
//    }

}