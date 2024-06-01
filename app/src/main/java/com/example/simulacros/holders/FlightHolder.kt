package com.example.simulacros.holders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacros.R

class FlightHolder(v: View) : RecyclerView.ViewHolder(v) {
    private var view: View

    init {
        this.view = v
    }
    fun setAirline(airline: String) {
        val txt: TextView = view.findViewById(R.id.card_airline_name)
        txt.text = airline
    }
    fun getButton (): Button {
        return view.findViewById(R.id.card_button)
    }
    fun getImage(): ImageView {
        return view.findViewById(R.id.card_airline_logo)
    }

    fun setDepartureAirportName(departureAirportName: String) {
        val txt: TextView = view.findViewById(R.id.card_airport_name)
        txt.text = departureAirportName
    }
    fun setDepartureAirportId(departureAirportId: String) {
        val txt: TextView = view.findViewById(R.id.card_airport_id)
        txt.text = departureAirportId
    }
    fun setArrivalAirportName(arrivalAirportName: String) {
        val txt: TextView = view.findViewById(R.id.card_airport_name_arrival)
        txt.text = arrivalAirportName
    }

    fun setArrivalAirportId(arrivalAirportId: String) {
        val txt: TextView = view.findViewById(R.id.card_airport_id_arrival)
        txt.text = arrivalAirportId
    }


    fun setTotalDuration(totalDuration: String) {
        val txt: TextView = view.findViewById(R.id.card_duration)
        txt.text = totalDuration
    }

    fun setPrice(price: Int) {
        val txt: TextView = view.findViewById(R.id.card_flight_price)
        txt.text = price.toString()
    }
}