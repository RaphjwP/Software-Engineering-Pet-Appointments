package com.example.meetmypetbuddy.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meetmypetbuddy.databinding.ClinicHistoryRowLayoutBinding
import com.example.meetmypetbuddy.databinding.PetRowLayoutBinding
import com.example.meetmypetbuddy.databinding.UserHistroyRowLayoutBinding
import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Pet

class UserAppointmentsViewHolder(private val binding: UserHistroyRowLayoutBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(p: Appointment){
        binding.bndUserAppointments = p
        binding.executePendingBindings()
    }
}


class UserAppointmentsAdapter(val userAppointments:MutableList<Appointment>, val context: Context)
    : RecyclerView.Adapter<UserAppointmentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAppointmentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserHistroyRowLayoutBinding.inflate(layoutInflater, parent, false)

        return UserAppointmentsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userAppointments.size
    }

    override fun onBindViewHolder(holder: UserAppointmentsViewHolder, position: Int) {
        val currAppointment = this.userAppointments.get(position)
        holder?.bind(currAppointment)
    }
}