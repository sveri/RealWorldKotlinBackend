package de.sveri.realworld.model

import java.io.Serializable


data class Profile(val id: Int,
                   val username: String,
                   val bio: String? = null,
                   val image: String? = null,
                   val following: Boolean = false) : Serializable