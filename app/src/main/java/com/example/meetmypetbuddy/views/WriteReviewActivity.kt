package com.example.meetmypetbuddy.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.controllers.ClinicReviewActivityController
import com.example.meetmypetbuddy.databinding.ActivityWriteReviewBinding
import com.example.meetmypetbuddy.models.Review
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WriteReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteReviewBinding

    private val vm: ClinicReviewActivityController by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityWriteReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var description = binding.editTextReviewDescription.text.toString()
        val clinicName: String = intent.getStringExtra("Clinic_name").toString()
        val doctorName: String = intent.getStringExtra("doctor_name").toString()
        val rating: Float = binding.ratingBar.rating

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter)

        binding.btnWriteReviewCancel.setOnClickListener {
            var intent = Intent(this, ClinicReviewActivity::class.java)
            startActivity(intent)
        }

        binding.btnWriteReviewSubmit.setOnClickListener {
            var review: Review = Review(written_by = "user", review_description = description, clinic_name = clinicName, doctor_name = doctorName, date=formatted, rating=rating, feedback_given = "")

            vm.postReviewToAPI(review)

            var intent = Intent(this, ClinicReviewActivity::class.java)
            startActivity(intent)
        }
    }
}