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
    val offers: LiveData<List<Offer>> = _offers
}