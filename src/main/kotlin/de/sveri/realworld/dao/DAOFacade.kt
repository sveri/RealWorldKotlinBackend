package de.sveri.realworld.dao

import de.sveri.realworld.model.User
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import java.io.Closeable
import java.io.File

/**
 * Created by sveri on 24.05.17.
 */

interface DAOFacade : Closeable {
    fun init()
//    fun getUser(id: Int)
//    fun countReplies(id: Int): Int
//    fun createKweet(user: String, text: String, replyTo: Int? = null, date: DateTime = DateTime.now()): Int
//    fun deleteKweet(id: Int)
//    fun getKweet(id: Int): Kweet
//    fun userKweets(userId: String): List<Int>
//    fun user(userId: String, hash: String? = null): User?
//    fun userByEmail(email: String): User?
//    fun createUser(user: User)
//    fun top(count: Int = 10): List<Int>
//    fun latest(count: Int = 10): List<Int>
}

class DAOFacadeDatabase(val db: Database = Database.connect("jdbc:h2:mem:realworldtest", driver = "org.h2.Driver")) : DAOFacade {

    constructor(dir: File) : this(Database.connect("jdbc:h2:file:${dir.canonicalFile.absolutePath}", driver = "org.h2.Driver"))

    override fun init() {
        db.transaction {
            create(Users)
        }
    }

    fun createUser(email: String, username: String, passwordHash: String, token: String?, bio: String?, image: Byte?) {
        return db.transaction {

            Users.insert {
                it[Users.email] = email
                it[Users.username] = username
                it[Users.token] = token
                it[Users.bio] = bio
                it[Users.passwordHash] = passwordHash
            }
        }
    }

    override fun close() {

    }

    fun getUserByMail(email: String) = db.transaction {
        val row = Users.select { Users.email.eq(email) }.single()
        User(row[Users.id], row[Users.email], row[Users.token], row[Users.passwordHash], row[Users.username],
                row[Users.bio], null) // TODO convert image here

    }

}
