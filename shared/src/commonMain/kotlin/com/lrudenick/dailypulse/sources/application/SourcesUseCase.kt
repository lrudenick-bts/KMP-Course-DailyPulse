package com.lrudenick.dailypulse.sources.application

import com.lrudenick.dailypulse.sources.data.SourceRaw
import com.lrudenick.dailypulse.sources.data.SourcesRepository

class SourcesUseCase (private val repository: SourcesRepository) {

    suspend fun getSources(): List<Source> {
        val sourcesRaw = repository.getSources()
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> = sourcesRaw.map { raw ->
        Source(
            id = raw.id,
            name = raw.name,
            desc = raw.desc,
            locale = "${raw.country} - ${raw.language}"
        )
    }

}