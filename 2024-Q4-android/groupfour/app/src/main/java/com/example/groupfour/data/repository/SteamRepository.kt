package com.example.groupfour.data.repository

import com.example.groupfour.data.model.NewsItem
import com.example.groupfour.data.network.RetrofitClient
import com.example.groupfour.data.network.SteamApi

class SteamRepository {
    private val api = RetrofitClient.instance.create(SteamApi::class.java)

    suspend fun fetchNews(appId: Int, count: Int, maxLength: Int): List<NewsItem> {
        val response = api.getNewsForApp(appId, count, maxLength)
        return response.appnews.newsitems
    }
}