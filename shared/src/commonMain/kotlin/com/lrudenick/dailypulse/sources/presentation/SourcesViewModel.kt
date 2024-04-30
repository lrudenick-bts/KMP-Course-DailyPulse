package com.lrudenick.dailypulse.sources.presentation

import com.lrudenick.dailypulse.BaseViewModel
import com.lrudenick.dailypulse.sources.application.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(
    private val useCase: SourcesUseCase
) : BaseViewModel() {

    private val _sourcesState: MutableStateFlow<SourcesState> =
        MutableStateFlow(SourcesState(loading = true))

    val sourcesState = _sourcesState.asStateFlow()

    init {
        getSources()
    }

    private fun getSources() {
        scope.launch {
            _sourcesState.emit(
                SourcesState(
                    loading = true,
                    sources = _sourcesState.value.sources
                )
            )
            val sources = useCase.getSources()
            _sourcesState.emit(SourcesState(sources = sources))
        }
    }

}