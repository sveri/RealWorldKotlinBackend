package de.sveri.realworld.model

import java.io.Serializable

data class User(val id: Int,
                val email: String,
                val token: String?,
                val passwordHash: String,
                val username: String,
                val bio: String? = null,
                val image: String? = null) : Serializable