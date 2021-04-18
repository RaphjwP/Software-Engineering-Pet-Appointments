package com.example.meetmypetbuddy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meetmypetbuddy.databinding.PetRowLayoutBinding
import com.example.meetmypetbuddy.models.Pet

class PetsViewHodler(private val binding: PetRowLayoutBinding) :RecyclerView.ViewHolder(binding.root){
    fun bind(p:Pet){
        binding.bndPet = p
        binding.executePendingBindings()
    }
}


class PetsAdapter(val pets:MutableList<Pet>, val context: Context)
    :RecyclerView.Adapter<PetsViewHodler>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHodler {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PetRowLayoutBinding.inflate(layoutInflater, parent, false)

        return PetsViewHodler(binding)
    }

    override fun getItemCount(): Int {
        return pets.size
    }

    override fun onBindViewHolder(holder: PetsViewHodler, position: Int) {
        val currPet = this.pets.get(position)
        holder?.bind(currPet)
    }
}