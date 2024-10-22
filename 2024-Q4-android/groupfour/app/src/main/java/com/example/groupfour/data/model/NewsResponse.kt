package com.example.groupfour.data.model

data class NewsResponse(val appnews: AppNews)
data class AppNews(val newsitems: List<NewsItem>)