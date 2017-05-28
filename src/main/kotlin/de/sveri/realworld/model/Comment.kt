package de.sveri.realworld.model

import org.joda.time.DateTime


data class Comment(val id: Int,
                   val createdAt: DateTime = DateTime.now(),
                   val updatedAt: DateTime?,
                   val body: String,
                   val author: User)

data class Comments(val comments: List<Comment>)