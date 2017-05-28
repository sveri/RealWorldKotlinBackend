package de.sveri.realworld

import com.mchange.v2.c3p0.ComboPooledDataSource
import de.sveri.realworld.dao.DAOFacadeDatabase
import de.sveri.realworld.dao.Users
import org.h2.Driver
import org.h2.jdbc.JdbcSQLException
import org.jetbrains.exposed.sql.Database
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNull

/**
 * Created by sveri on 24.05.17.
 */


class DAOFacadeTest {

    val pool = ComboPooledDataSource().apply {
        driverClass = Driver::class.java.name
        jdbcUrl = "jdbc:h2:mem:realworldtest"
        user = ""
        password = ""
    }

    val daoFacadeDatabase = DAOFacadeDatabase(Database.connect(pool))

    private val email = "foo@bar.de"

    @Before fun before() {
        daoFacadeDatabase.init()
        daoFacadeDatabase.createUser(email, "foobar", "some-hash", null, null, null)
    }

    @After fun after() {
        daoFacadeDatabase.db.transaction {
            drop(Users)
        }
    }


    @Test
    fun insertSameUserOnlyOnce() {
        assertFails {
            daoFacadeDatabase.createUser(email, "foobar", "some-hash", null, null, null)
        }
    }

    @Test fun getUserByEmail() {
        val userByMail = daoFacadeDatabase.getUserByMail(email)
        assertEquals(1, userByMail.id)
        assertEquals(email, userByMail.email)
        assertNull(userByMail.bio)
    }
}