package com.example.simulacros.domain.model

import android.os.Parcel
import android.os.Parcelable

class TrendingDestination(var destino: String, var pais: String, var codigo: String, var image: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(destino)
        parcel.writeString(pais)
        parcel.writeString(codigo)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TrendingDestination> {
        override fun createFromParcel(parcel: Parcel): TrendingDestination {
            return TrendingDestination(parcel)
        }

        override fun newArray(size: Int): Array<TrendingDestination?> {
            return arrayOfNulls(size)
        }
    }
}