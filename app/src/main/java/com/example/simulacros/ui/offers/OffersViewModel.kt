package com.example.simulacros.ui.offers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simulacros.R
import com.example.simulacros.domain.model.Offer

class OffersViewModel : ViewModel() {

    private val _offers = MutableLiveData<List<Offer>>().apply {
        value = listOf(
            Offer("Get 20% discount with Mastercard credit cards",
                "Use your mastercard with any transaction and get 20% discount instantly! ",
                R.drawable.mastercard),
            Offer("25% discount with your VISA credit or debit cards",
                "Use your VISA credit or debit card with any transaction and get 25% discount instantly! ",
                R.drawable.visa)
        )
    }
    val offers: LiveData<List<Offer>> = _offers

}

