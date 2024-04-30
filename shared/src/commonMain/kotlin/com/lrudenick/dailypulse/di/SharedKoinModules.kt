package com.lrudenick.dailypulse.di

import com.lrudenick.dailypulse.articles.di.articlesModule
import com.lrudenick.dailypulse.sources.di.sourcesModule

val sharedKoinModules = listOf(
    networkModule,
    articlesModule,
    sourcesModule
)