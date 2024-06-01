package com.example.simulacros.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simulacros.R
import com.example.simulacros.domain.model.Flight
import com.example.simulacros.holders.FlightHolder
import com.example.simulacros.listener.OnFlightItemClickedListener

class FlightListAdapter(
    private val flightList: List<Flight>,
    private val onItemClick: OnFlightItemClickedListener
)
: RecyclerView.Adapter<FlightHolder>(){


    override fun getItemCount() = flightList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_flight,parent,false)
        return (FlightHolder(view))
    }

    override fun onBindViewHolder(holder: FlightHolder, position: Int) {
        val flight = flightList[position]
        holder.setAirline(flight.airline)
        holder.setTotalDuration(flight.totalDuration)

        Glide.with(holder.itemView.context)
            .load(flight.airlineLogo)
            .centerCrop()
            .into(holder.getImage());

        holder.getCardLayout().setOnClickListener{
            onItemClick.onFlightItemDetail(flight)
        }

    }
}
