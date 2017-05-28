package de.sveri.realworld

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import de.sveri.realworld.model.User
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
            addHeader(HttpHeaders.Accept, ContentType.Application.Json.toString())
        }) {
            assertEquals(HttpStatusCode.OK, response.status())
            val parser: Parser = Parser()
            val stringBuilder: StringBuilder = StringBuilder(response.content.toString())
            println(parser.parse(stringBuilder) as JsonObject)

        }
    }
}