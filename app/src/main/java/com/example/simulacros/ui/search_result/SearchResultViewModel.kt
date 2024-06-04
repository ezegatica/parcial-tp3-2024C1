package com.example.simulacros.ui.search_result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simulacros.data.FlightRepository
import com.example.simulacros.data.model.BestFlight
import com.example.simulacros.domain.GetFlightsUseCase
import com.example.simulacros.domain.model.Flight
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val getFlightsUseCase: GetFlightsUseCase,
    private val flightRepository: FlightRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    var listFlight = MutableLiveData<List<Flight>?>()


    init {
        addFlightsToList()
    }

    fun addFlightsToList() {
        CoroutineScope(Dispatchers.Main).launch {
            isLoading.postValue(true)

            val result = getFlightsUseCase()
            val bestFlights = result?.bestFlights

            listFlight.postValue( extractFlights(bestFlights))
            isLoading.postValue(false)
        }
    }

    fun extractFlights(bestFlights: List<BestFlight>?): List<Flight> {
        val flights = mutableListOf<Flight>()
        bestFlights?.forEach { bestFlight ->
            val firstFlight = bestFlight.flights.firstOrNull()
            val lastFlight = bestFlight.flights.lastOrNull()

            if (firstFlight != null && lastFlight != null) {
                val flight = Flight(
                    airline = firstFlight.airline,
                    airlineLogo = firstFlight.airlineLogo,
                    totalDuration = bestFlight.totalDuration.toString().toIntOrNull() ?: 0,
                    departureAirportName = firstFlight.departureAirport.name,
                    departureAirportId = firstFlight.departureAirport.id,
                    arrivalAirportName = lastFlight.arrivalAirport.name,
                    arrivalAirportId = lastFlight.arrivalAirport.id,
                    price = bestFlight.price
                )
                flights.add(flight)
            }
        }
        return flights
    }
}