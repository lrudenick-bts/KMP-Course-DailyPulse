package com.lrudenick.dailypulse.articles.di

import com.lrudenick.dailypulse.articles.data.ArticlesDataSource
import com.lrudenick.dailypulse.articles.data.ArticlesRepository
import com.lrudenick.dailypulse.articles.data.ArticlesService
import com.lrudenick.dailypulse.articles.application.ArticlesUseCase
import com.lrudenick.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}