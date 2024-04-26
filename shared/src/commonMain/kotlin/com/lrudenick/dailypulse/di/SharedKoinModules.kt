package com.lrudenick.dailypulse.di

import com.lrudenick.dailypulse.articles.di.articlesModule

val sharedKoinModules = listOf(
    networkModule,
    articlesModule
)