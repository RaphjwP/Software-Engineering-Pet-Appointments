package com.example.meetmypetbuddy.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meetmypetbuddy.databinding.ActivityAddnoteBinding
import com.example.meetmypetbuddy.databinding.ActivityFaqBinding

class AddNoteActivity :AppCompatActivity() {
    private lateinit var binding: ActivityAddnoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityAddnoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}