package com.example.mvvmroom.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmroom.model.room.Cat
import com.example.mvvmroom.model.repository.CatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainActivityViewModel(private val catRepository: CatRepository) : ViewModel() {

    private val _stateFlow = MutableStateFlow(emptyList<Cat>())
    val stateFlow = _stateFlow.asStateFlow()


    fun initViewModel() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = catRepository.doNetworkCall()
                catRepository.insertAll(result)

                if (result != null) {
                    _stateFlow.emit(result)
                }
                Log.d("YourViewModel", "Cats are ${catRepository.getAllDatas()[0]}")
                Log.d("YourViewModel", "Cats inserted and fetched successfully")
            } catch (e: Exception) {
                Log.e("YourViewModel", "Error inserting or fetching cats: ${e.message}")
            }
        }


    }


}





