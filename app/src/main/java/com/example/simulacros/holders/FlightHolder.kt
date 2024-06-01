package com.example.simulacros.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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
    fun getCardLayout (): CardView {
        return view.findViewById(R.id.flightCard)
    }
    fun getImage(): ImageView {
        return view.findViewById(R.id.card_airline_logo)
    }
    fun setTotalDuration(totalDuration: Int) {
        val txt: TextView = view.findViewById(R.id.card_duration)
        txt.text = totalDuration.toString()
    }
}