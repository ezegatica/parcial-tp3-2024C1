package com.example.simulacros.domain

import com.example.simulacros.data.FlightRepository
import com.example.simulacros.data.model.FlightResponseModel
import javax.inject.Inject

class GetFlightsUseCase @Inject constructor(private val repository: FlightRepository) {

    suspend operator fun invoke(): FlightResponseModel? {
        val flights = repository.getAllFlights()
        if (flights != null) {
            return flights
        }
        return null
    }
}