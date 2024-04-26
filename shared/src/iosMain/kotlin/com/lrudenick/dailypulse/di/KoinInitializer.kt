package com.lrudenick.dailypulse.di

import com.lrudenick.dailypulse.articles.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin() {
        modules(sharedKoinModules)
    }
}

class ArticlesInjector : KoinComponent {

    val articlesViewModel: ArticlesViewModel by inject()
}