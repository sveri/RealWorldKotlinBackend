package de.sveri.realworld.dao

import org.jetbrains.exposed.sql.Table

/**
 * Created by sveri on 25.05.17.
 */

object Users : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val email = varchar("email", 128).uniqueIndex()
    val token = varchar("token", 70).nullable()
    val username = varchar("username", 128)
    val bio = text("bio").nullable()
    val image = blob("image").nullable()
    val passwordHash = varchar("password_hash", 64)
}