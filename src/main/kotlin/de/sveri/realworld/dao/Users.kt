package de.sveri.realworld.dao

import org.jetbrains.exposed.sql.Table

/**
 * Created by sveri on 25.05.17.
 */

object Users : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val email = varchar("email", 128).uniqueIndex()
    val username = varchar("username", 128)
    val passwordHash = varchar("password_hash", 64)
    val bio = text("bio").nullable()
    val image = text("image").nullable()
    val token = varchar("token", 70).nullable()
}