package de.sveri.realworld.model

import org.joda.time.DateTime

enum class Tag {
    REACTJS, ANGULARJS
}

data class Article(val id: Int,
                   val slug: String?,
                   val title: String?,
                   val description: String?,
                   val body: String?,
                   val tagList: List<String>?,
                   val createdAt: DateTime = DateTime.now(),
                   val updatedAt: DateTime?,
                   val favorited: Boolean = false,
                   val favoritesCount: Int = 0,
                   val author: User)

data class Articles (val articles: List<Article>, val articlesCount: Int)