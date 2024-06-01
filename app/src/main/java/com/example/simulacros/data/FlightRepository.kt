package com.example.simulacros.data

import com.example.simulacros.data.model.FlightResponseModel
import com.example.simulacros.data.network.FlightService
import javax.inject.Inject

class FlightRepository @Inject constructor(
    private val remote: FlightService,
) {
    suspend fun getAllFlights() : FlightResponseModel? {
        val response = remote.getFlights()
        return response;
    }
}