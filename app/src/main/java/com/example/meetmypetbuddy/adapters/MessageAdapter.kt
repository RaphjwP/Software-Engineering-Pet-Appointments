package com.example.meetmypetbuddy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meetmypetbuddy.databinding.ReviewRowLayoutBinding
import com.example.meetmypetbuddy.models.Review

class MessageViewHolder(private val binding: ReviewRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(p: Review) {
        binding.bndReview = p;
        binding.executePendingBindings()
    }
}

class MessageAdapter (private val reviewers: List<Review>) : RecyclerView.Adapter<ReviewViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        var binding = ReviewRowLayoutBinding.inflate(inflater)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ReviewViewHolder, position: Int) {
        val review: Review = reviewers.get(position)
        viewHolder.bind(review)
    }

    override fun getItemCount(): Int {
        return reviewers.size
    }
}