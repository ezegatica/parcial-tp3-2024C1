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
        holder.setTotalDuration((flight.totalDuration/60).toString() + " h " + flight.totalDuration%60 + " m")
        holder.setDepartureAirportName(getFirstWord(flight.departureAirportName))
        holder.setDepartureAirportId(flight.departureAirportId)
        holder.setArrivalAirportName(getFirstWord(flight.arrivalAirportName))
        holder.setArrivalAirportId(flight.arrivalAirportId)
        holder.setPrice(flight.price)

        Glide.with(holder.itemView.context)
            .load(flight.airlineLogo)
            .centerCrop()
            .into(holder.getImage())

        holder.getButton().setOnClickListener{
            onItemClick.onFlightItemDetail(flight)
        }

    }
    fun getFirstWord(text: String): String {
        return text.split(" ").firstOrNull() ?: ""
    }
}
