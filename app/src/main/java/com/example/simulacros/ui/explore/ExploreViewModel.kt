package com.example.simulacros.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simulacros.R
import com.example.simulacros.domain.model.Offer
import com.example.simulacros.domain.model.TrendingDestination

class ExploreViewModel: ViewModel()  {
    private val _offers = MutableLiveData<List<Offer>>().apply {
        value = listOf(
            Offer("20% discount for Mastercard users",null,R.drawable.mastercard),
            Offer("25% discount for Visa credit cards",null,R.drawable.visa)
        )
    }

    private val _trendingDestinations = MutableLiveData<List<TrendingDestination>>().apply {
        value = listOf(
            TrendingDestination("Boracay","Philippines","5D4N",R.drawable.boracay),
            TrendingDestination("Baros","Maldives","7D6N",R.drawable.baros),
            TrendingDestination("Bali","Indonesia","3D2N",R.drawable.bali),
            TrendingDestination("Palawan","Philippines","3D2N",R.drawable.palawan)
        )}

    val offers: LiveData<List<Offer>> = _offers
    val trendingDestinations: LiveData<List<TrendingDestination>> = _trendingDestinations
}