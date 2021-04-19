package com.example.meetmypetbuddy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meetmypetbuddy.databinding.AppointmentRowLayoutBinding
import com.example.meetmypetbuddy.databinding.ClinicHistoryRowLayoutBinding
import com.example.meetmypetbuddy.databinding.PetRowLayoutBinding
import com.example.meetmypetbuddy.databinding.ReviewRowLayoutBinding
import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Pet
import com.example.meetmypetbuddy.models.Review

class AppointmentsViewHodler(private val binding: AppointmentRowLayoutBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(p: Appointment){
        binding.bndAppointments = p
        binding.executePendingBindings()
    }
}


class AppointmentsAdapter(val appointments: List<Appointment>) : RecyclerView.Adapter<AppointmentsViewHodler>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentsViewHodler {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        var binding = AppointmentRowLayoutBinding.inflate(inflater)
        return AppointmentsViewHodler(binding)
    }


    override fun onBindViewHolder(holder: AppointmentsViewHodler, position: Int) {
        val appointment : Appointment  = appointments.get(position)
        holder?.bind(appointment)
    }

    override fun getItemCount(): Int {
        return appointments.size
    }

}