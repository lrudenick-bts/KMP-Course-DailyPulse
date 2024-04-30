package com.lrudenick.dailypulse.articles.presentation

import com.lrudenick.dailypulse.BaseViewModel
import com.lrudenick.dailypulse.articles.application.ArticlesUseCase
import com.lrudenick.dailypulse.articles.presentation.ArticlesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState = _articlesState.asStateFlow()

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(
                ArticlesState(
                    loading = true,
                    articles = _articlesState.value.articles
                )
            )
            val articles = useCase.getArticles(forceFetch)
            _articlesState.emit(ArticlesState(articles = articles))
        }
    }

    val isRefreshing: Boolean get() = _articlesState.value.loading

}