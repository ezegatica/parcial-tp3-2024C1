package com.example.simulacros.data.model

import com.google.gson.annotations.SerializedName

data class FlightResponseModel(
    @SerializedName("search_metadata") val searchMetadata: SearchMetadata,
    @SerializedName("search_parameters") val searchParameters: SearchParameters,
    @SerializedName("best_flights") val bestFlights: List<BestFlight>,
    @SerializedName("other_flights") val otherFlights: List<OtherFlight>,
    @SerializedName("price_insights") val priceInsights: PriceInsights
)

data class SearchMetadata(
    @SerializedName("id") val id: String,
    @SerializedName("status") val status: String,
    @SerializedName("json_endpoint") val jsonEndpoint: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("processed_at") val processedAt: String,
    @SerializedName("google_flights_url") val googleFlightsUrl: String,
    @SerializedName("raw_html_file") val rawHtmlFile: String,
    @SerializedName("prettify_html_file") val prettifyHtmlFile: String,
    @SerializedName("total_time_taken") val totalTimeTaken: Double
)

data class SearchParameters(
    @SerializedName("engine") val engine: String,
    @SerializedName("hl") val hl: String,
    @SerializedName("gl") val gl: String,
    @SerializedName("departure_id") val departureId: String,
    @SerializedName("arrival_id") val arrivalId: String,
    @SerializedName("outbound_date") val outboundDate: String,
    @SerializedName("return_date") val returnDate: String
)

data class BestFlight(
    @SerializedName("flights") val flights: List<Flight>,
    @SerializedName("layovers") val layovers: List<Layover>,
    @SerializedName("total_duration") val totalDuration: Int,
    @SerializedName("carbon_emissions") val carbonEmissions: CarbonEmissions,
    @SerializedName("price") val price: Int,
    @SerializedName("type") val type: String,
    @SerializedName("airline_logo") val airlineLogo: String,
    @SerializedName("departure_token") val departureToken: String
)

data class OtherFlight(
    @SerializedName("flights") val flights: List<Flight>,
    @SerializedName("layovers") val layovers: List<Layover>,
    @SerializedName("total_duration") val totalDuration: Int,
    @SerializedName("carbon_emissions") val carbonEmissions: CarbonEmissions,
    @SerializedName("price") val price: Int,
    @SerializedName("type") val type: String,
    @SerializedName("airline_logo") val airlineLogo: String,
    @SerializedName("departure_token") val departureToken: String
)

data class Flight(
    @SerializedName("departure_airport") val departureAirport: Airport,
    @SerializedName("arrival_airport") val arrivalAirport: Airport,
    @SerializedName("duration") val duration: Int,
    @SerializedName("airplane") val airplane: String,
    @SerializedName("airline") val airline: String,
    @SerializedName("airline_logo") val airlineLogo: String,
    @SerializedName("travel_class") val travelClass: String,
    @SerializedName("flight_number") val flightNumber: String,
    @SerializedName("legroom") val legroom: String,
    @SerializedName("extensions") val extensions: List<String>,
    @SerializedName("overnight") val overnight: Boolean
)

data class Airport(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: String,
    @SerializedName("time") val time: String
)

data class Layover(
    @SerializedName("duration") val duration: Int,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: String
)

data class CarbonEmissions(
    @SerializedName("this_flight") val thisFlight: Int,
    @SerializedName("typical_for_this_route") val typicalForThisRoute: Int,
    @SerializedName("difference_percent") val differencePercent: Int
)

data class PriceInsights(
    @SerializedName("lowest_price") val lowestPrice: Int,
    @SerializedName("price_level") val priceLevel: String,
    @SerializedName("typical_price_range") val typicalPriceRange: List<Int>,
    @SerializedName("price_history") val priceHistory: List<List<Int>>
)

data class PriceHistoryEntry(
    @SerializedName("0") val timestamp: Long,
    @SerializedName("1") val price: Int
)