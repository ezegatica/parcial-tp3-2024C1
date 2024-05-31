package com.example.simulacros.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simulacros.R
import com.example.simulacros.domain.model.Offer

class ExploreViewModel: ViewModel()  {
    private val _offers = MutableLiveData<List<Offer>>().apply {
        value = listOf(
            Offer("20% discount for Mastercard users","Use your mastercard with any transaction and get 20% discount instantly",R.drawable.mastercard),
            Offer("25% discount for Visa credit cards","Use your VISA credit or debit card with any transaction and get 25% discount instantly",R.drawable.visa)
        )
    }
    val offers: LiveData<List<Offer>> = _offers
}