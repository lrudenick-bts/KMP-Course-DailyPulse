package com.lrudenick.dailypulse.articles.data

import com.lrudenick.dailypulse.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    suspend fun fetchArticles(): List<ArticleRaw> {
        val country = "us"
        val category = "business"
        val apiKey = BuildKonfig.API_KEY
        val response: ArticlesResponse = httpClient.get(
            "https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey"
        ).body()
        return response.articles
    }
}