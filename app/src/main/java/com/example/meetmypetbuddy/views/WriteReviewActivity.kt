package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.controllers.ReviewController
import com.example.meetmypetbuddy.databinding.ActivityWriteReviewBinding
import com.example.meetmypetbuddy.models.Review
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WriteReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteReviewBinding

    private val vm: ReviewController by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityWriteReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clinicName: String = intent.getStringExtra("clinic_name").toString()
        binding.txtWriteClinicName.text = clinicName


        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter).toString()

        binding.btnWriteReviewCancel.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnWriteReviewSubmit.setOnClickListener {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val formatted = current.format(formatter).toString()
            val doctorName: String = intent.getStringExtra("doctor_name").toString()
            val rating: Float = binding.ratingBar.rating

            val clinicName: String = intent.getStringExtra("clinic_name").toString()

            var description = binding.editTextReviewDescription.text.toString()
            var review = Review(written_by = "user", review_description = description, clinic_name = clinicName, doctor_name = doctorName, date=formatted, rating=rating, feedback_given = " ")

            vm.postReviewToAPI(review)

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}