package com.lrudenick.dailypulse.articles.presentation

import com.lrudenick.dailypulse.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)