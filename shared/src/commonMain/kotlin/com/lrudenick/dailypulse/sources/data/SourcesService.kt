package com.lrudenick.dailypulse.sources.data

import com.lrudenick.dailypulse.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {

    suspend fun fetchSources(): List<SourceRaw> {
        val apiKey = BuildKonfig.API_KEY
        val response: SourcesResponse = httpClient.get(
            "https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey"
        ).body()
        return response.sources
    }

}