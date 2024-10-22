package com.example.groupfour.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Simulating the user logged in state
    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn: StateFlow<Boolean> get() = _isUserLoggedIn

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun simulateLoading() {
        viewModelScope.launch {
            setLoading(true)
            delay(800)
            setLoading(false)
        }
    }
}