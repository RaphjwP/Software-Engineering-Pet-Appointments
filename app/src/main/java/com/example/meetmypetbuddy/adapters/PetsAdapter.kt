package com.example.meetmypetbuddy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meetmypetbuddy.databinding.PetRowLayoutBinding
import com.example.meetmypetbuddy.models.Pet
import com.example.meetmypetbuddy.models.Review

class PetsViewHolder(private val binding: PetRowLayoutBinding) :RecyclerView.ViewHolder(binding.root){
    fun bind(p:Pet){
        binding.bndPet = p
        binding.executePendingBindings()
    }
}


class PetsAdapter(private val pets: List<Pet>) :RecyclerView.Adapter<PetsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val binding = PetRowLayoutBinding.inflate(inflater)

        return PetsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PetsViewHolder, position: Int) {
        val pet: Pet = pets.get(position)
        holder.bind(pet)
    }

    override fun getItemCount(): Int {
       return pets.size
    }
}