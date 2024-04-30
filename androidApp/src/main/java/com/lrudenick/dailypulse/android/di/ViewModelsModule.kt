package com.lrudenick.dailypulse.android.di

import com.lrudenick.dailypulse.articles.presentation.ArticlesViewModel
import com.lrudenick.dailypulse.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}