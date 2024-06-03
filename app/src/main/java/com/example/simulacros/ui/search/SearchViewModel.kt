package com.example.simulacros.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simulacros.R
import com.example.simulacros.domain.model.Offer

class SearchViewModel : ViewModel()  {
    private val _offers = MutableLiveData<List<Offer>>().apply {
        value = listOf(
            Offer("20% discount for Mastercard users",null, R.drawable.mastercard),
            Offer("25% discount for Visa credit cards",null, R.drawable.visa)
        )
    }

    private val _passengers = MutableLiveData<List<String>>().apply {
        value = listOf("1 Adult", "2 Adults", "3 Adults", "4 Adults")
    }

    private val _classes = MutableLiveData<List<String>>().apply {
        value = listOf("Economy", "Business", "First")
    }

    val passengers: LiveData<List<String>> = _passengers
    val classes: LiveData<List<String>> = _classes

    val offers: LiveData<List<Offer>> = _offers
}