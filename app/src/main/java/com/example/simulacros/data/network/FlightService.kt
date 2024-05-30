package com.example.simulacros.data.network

import com.example.simulacros.data.model.DogModel
import com.example.simulacros.data.model.FlightResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FlightService @Inject constructor(private val service:FlightApiClient) {

    suspend fun getFlights(): FlightResponseModel? {
        return withContext(Dispatchers.IO) {
            val response = service.getFlightSearchResults()
            response.body()
        }
    }

}