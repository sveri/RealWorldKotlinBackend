package de.sveri.realworld

import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.testing.*
import org.junit.*
import kotlin.test.*

/**
 * Created by sveri on 24.05.17.
 */


class RoutingTest {

    @Test fun testRequest() = withTestApplication(Application::main) {
        with (handleRequest(HttpMethod.Get, "/index.html")) {
            assertFalse(requestHandled)
        }
    }

    @Test fun getUser() = withTestApplication(Application::main) {
        with (handleRequest(HttpMethod.Get, "/api/user") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
        }) {
            assertEquals(HttpStatusCode.OK, response.status())
            println(response.content)
        }
    }
}