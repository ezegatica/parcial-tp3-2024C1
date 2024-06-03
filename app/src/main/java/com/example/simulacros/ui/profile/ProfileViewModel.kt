package com.example.simulacros.ui.profile
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    val descriptionText = MutableLiveData<String>("I like the beach, mountains, forest and everything about nature! :)")
    val titleText = MutableLiveData<String>("Martin")
    val subtitleText = MutableLiveData<String>("Baguio, Philippines")
}