package com.example.meetmypetbuddy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meetmypetbuddy.databinding.ClinicHistoryRowLayoutBinding
import com.example.meetmypetbuddy.databinding.PetRowLayoutBinding
import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Pet

class AppointmentsViewHodler(private val binding: ClinicHistoryRowLayoutBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(p: Appointment){
        binding.bndAppointments = p
        binding.executePendingBindings()
    }
}


class AppointmentsAdapter(val appointments:MutableList<Appointment>, val context: Context)
    : RecyclerView.Adapter<AppointmentsViewHodler>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentsViewHodler {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ClinicHistoryRowLayoutBinding.inflate(layoutInflater, parent, false)

        return AppointmentsViewHodler(binding)
    }

    override fun getItemCount(): Int {
        return appointments.size
    }

    override fun onBindViewHolder(holder: AppointmentsViewHodler, position: Int) {
        val currAppointment = this.appointments.get(position)
        holder?.bind(currAppointment)
    }
}