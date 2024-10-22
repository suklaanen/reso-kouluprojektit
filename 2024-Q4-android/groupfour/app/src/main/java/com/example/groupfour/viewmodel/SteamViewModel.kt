package com.example.groupfour.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groupfour.data.model.NewsItem
import com.example.groupfour.data.repository.SteamRepository
import kotlinx.coroutines.launch

class SteamViewModel : ViewModel() {
    private val repository = SteamRepository()
    val news = mutableStateOf<List<NewsItem>>(emptyList())
    val loading = mutableStateOf(true)
    val error = mutableStateOf<String?>(null)

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                news.value = repository.fetchNews(1086940, 5, 280)
            } catch (e: Exception) {
                Log.e("SteamViewModel", "Error fetching news", e)
                error.value = "Failed to fetch news: ${e.message}"
            } finally {
                loading.value = false
            }
        }
    }
}