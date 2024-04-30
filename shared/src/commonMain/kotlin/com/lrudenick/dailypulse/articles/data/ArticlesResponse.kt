package com.lrudenick.dailypulse.articles.data

import com.lrudenick.dailypulse.articles.data.ArticleRaw
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleRaw>
)