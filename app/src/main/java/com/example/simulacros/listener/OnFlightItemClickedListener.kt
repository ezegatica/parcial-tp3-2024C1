package com.example.simulacros.listener

import com.example.simulacros.domain.model.Flight

interface OnFlightItemClickedListener {
    fun onFlightItemDetail(flight: Flight)
}