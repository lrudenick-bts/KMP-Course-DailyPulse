package com.lrudenick.dailypulse.articles.data

import com.lrudenick.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles(): List<ArticleRaw> =
        database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() = database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            title = articleRaw.title,
            desc = articleRaw.desc,
            date = articleRaw.date,
            imageUrl = articleRaw.imageUrl
        )
    }


    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(
        title = title,
        desc = desc,
        date = date,
        imageUrl = imageUrl
    )
}