package com.lrudenick.dailypulse.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("title") var title: String,
    @SerialName("description") var desc: String? = null,
    @SerialName("urlToImage") var imageUrl: String? = null,
    @SerialName("publishedAt") var date: String,
)
