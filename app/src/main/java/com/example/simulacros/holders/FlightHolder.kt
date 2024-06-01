package com.example.simulacros.holders

import android.view.View
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
        val txt: TextView = view.findViewById(R.id.texto1)
        txt.text = airline
    }
    fun getCardLayout (): CardView {
        return view.findViewById(R.id.flightCard)
    }
    fun setAirlineLogo(airlineLogo: String) {
        val txt: TextView = view.findViewById(R.id.texto2)
        txt.text = airlineLogo
    }
    fun setTotalDuration(totalDuration: Int) {
        val txt: TextView = view.findViewById(R.id.texto3)
        txt.text = totalDuration.toString()
    }
}