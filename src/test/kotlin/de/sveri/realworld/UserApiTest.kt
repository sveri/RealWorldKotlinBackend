package de.sveri.realworld

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.http.HttpHeaders
import org.jetbrains.ktor.http.HttpMethod
import org.jetbrains.ktor.http.HttpStatusCode
import org.jetbrains.ktor.testing.handleRequest
import org.jetbrains.ktor.testing.withTestApplication
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class UserApiTest {

    @Test fun registerUser() = withTestApplication(Application::main) {
        with (handleRequest(HttpMethod.Post, "/api/users") {
            addHeader(HttpHeaders.Accept, ContentType.Application.Json.toString())
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
        }) {

            assertEquals(HttpStatusCode.OK, response.status())

        }
    }
}