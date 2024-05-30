package com.example.simulacros.data

import com.example.simulacros.data.database.dao.DogDao
import com.example.simulacros.data.database.entities.DogEntity
import com.example.simulacros.data.model.FlightResponseModel
import com.example.simulacros.data.network.DogService
import com.example.simulacros.data.network.FlightService
import com.example.simulacros.domain.model.Dog
import com.example.simulacros.domain.model.toDomain
import javax.inject.Inject

class FlightRepository @Inject constructor(
    private val remote: FlightService,
) {
    suspend fun getAllFlights() : FlightResponseModel? {
        val response = remote.getFlights()
        return response;
    }
}