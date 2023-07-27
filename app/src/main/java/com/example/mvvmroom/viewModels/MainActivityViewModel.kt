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
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = catRepository.doNetworkCall()
            if (result != null) {
                _stateFlow.emit(result)
            }
        }
    }


}





