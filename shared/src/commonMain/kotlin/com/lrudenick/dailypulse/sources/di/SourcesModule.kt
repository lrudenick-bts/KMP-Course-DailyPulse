package com.lrudenick.dailypulse.sources.di

import com.lrudenick.dailypulse.sources.application.SourcesUseCase
import com.lrudenick.dailypulse.sources.data.SourcesDataSource
import com.lrudenick.dailypulse.sources.data.SourcesRepository
import com.lrudenick.dailypulse.sources.data.SourcesService
import com.lrudenick.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
}