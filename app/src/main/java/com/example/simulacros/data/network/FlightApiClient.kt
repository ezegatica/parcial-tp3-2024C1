package com.example.simulacros.data.network

import com.example.simulacros.data.model.FlightResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FlightApiClient {
    @GET("/search?engine=google_flights&api_key=123&departure_id=EZE&arrival_id=MIA&outbound_date=2024-05-31&return_date=2024-06-10")
    suspend fun getFlightSearchResults(): Response<FlightResponseModel>
}