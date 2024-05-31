package com.example.simulacros.ui.search_result

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simulacros.data.DogRepository
import com.example.simulacros.data.FlightRepository
import com.example.simulacros.data.database.entities.DogEntity
import com.example.simulacros.domain.GetDogListUseCase
import com.example.simulacros.domain.GetFlightsUseCase
import com.example.simulacros.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val getDogListUseCase: GetDogListUseCase,
    private val repository: DogRepository,
    private val getFlightsUseCase: GetFlightsUseCase,
    private val flightRepository: FlightRepository
) : ViewModel() {

    var listDog = MutableLiveData<List<Dog>?>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        addDogsToList()
    }

    fun addDogsToList() {
        CoroutineScope(Dispatchers.Main).launch {
            isLoading.postValue(true)

                val dogs = ArrayList<DogEntity>()
                dogs.add(DogEntity(0, "test", "test", "test", 10, "https://images.dog.ceo/breeds/akita/512px-Ainu-Dog.jpg"))
                dogs.add(DogEntity(0, "test 1", "test 1", "test 1", 5, "https://images.dog.ceo/breeds/akita/512px-Akita_inu.jpg"))
                dogs.add(DogEntity(0, "test 2", "test 2", "test 2", 3, "https://images.dog.ceo/breeds/akita/Akina_Inu_in_Riga_1.jpg"))
                repository.insertDogs(dogs.toList())
                val result = repository.getAllDogsFromDatabase()
            val result2 = getFlightsUseCase()

            Log.e("Flights", result2.toString())
            Log.i("Flight2s", "holaa")

            listDog.postValue(result)
            isLoading.postValue(false)
        }
    }
}