package com.lrudenick.dailypulse.articles.di

import com.lrudenick.dailypulse.articles.ArticlesDataSource
import com.lrudenick.dailypulse.articles.ArticlesRepository
import com.lrudenick.dailypulse.articles.ArticlesService
import com.lrudenick.dailypulse.articles.ArticlesUseCase
import com.lrudenick.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}