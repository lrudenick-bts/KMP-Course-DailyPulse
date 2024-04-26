package com.lrudenick.dailypulse.articles

import com.lrudenick.dailypulse.BaseViewModel
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

    private fun getArticles() {
        scope.launch {
            val articles = useCase.getArticles()
            _articlesState.emit(ArticlesState(articles = articles))
        }
    }

}