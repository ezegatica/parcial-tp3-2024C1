package com.example.simulacros.ui.profile
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData

class ProfileViewModel : ViewModel() {
    private val _descriptionText = MutableLiveData<String>().apply { value = "I like the beach, mountains, forest and everything about nature! :)" }
    private val _subtitleText = MutableLiveData<String>().apply { value = "Baguio, Philippines" }

    val descriptionText: LiveData<String> =_descriptionText
    val subtitleText: LiveData<String> = _subtitleText
    fun setDescription(text: String) {
        _descriptionText.value = text
    }
    fun setSubtitle(text: String) {
        _subtitleText.value = text
    }
}