package com.example.simulacros.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Flight(
    var airline: String,
    var airlineLogo: String,
    var totalDuration: Int,
    var departureAirportName: String,
    var departureAirportId: String,
    var arrivalAirportName: String,
    var arrivalAirportId: String,
    var price:  Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(airline)
        parcel.writeString(airlineLogo)
        parcel.writeInt(totalDuration)
        parcel.writeString(departureAirportName)
        parcel.writeString(departureAirportId)
        parcel.writeString(arrivalAirportName)
        parcel.writeString(arrivalAirportId)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Flight> {
        override fun createFromParcel(parcel: Parcel): Flight {
            return Flight(parcel)
        }

        override fun newArray(size: Int): Array<Flight?> {
            return arrayOfNulls(size)
        }
    }
}
