package com.example.simulacros.ui.offers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OffersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is offers Fragment"
    }
    val text: LiveData<String> = _text
}