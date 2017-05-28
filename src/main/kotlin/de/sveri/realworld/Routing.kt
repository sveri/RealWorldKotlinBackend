package de.sveri.realworld

import com.google.gson.GsonBuilder
import de.sveri.realworld.model.User
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.*
import org.jetbrains.ktor.application.ApplicationCallPipeline
import org.jetbrains.ktor.content.TextContent
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.request.acceptItems
import org.jetbrains.ktor.transform.transform

/**
 * Created by sveri on 24.05.17.
 */

class JsonResponse(val data: Any)

fun Route.api() {

    route("/api") {

        val gson = GsonBuilder().create()

            intercept(ApplicationCallPipeline.Infrastructure) { call ->
        if (call.request.acceptItems().any { it.value == "application/json" }) {
            call.transform.register<JsonResponse> { value ->
                TextContent(gson.toJson(value.data), ContentType.Application.Json)
            }
        }
    }

        post("users/login") {
            call.respondText("Hello, wasdfasdf!")
        }

        get("user") {
            call.respond(JsonResponse(User(1, "foo", "bar", "hash", "username")))
        }
    }

}
