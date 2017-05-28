package de.sveri.realworld

/**
 * Created by sveri on 23.05.17.
 */

//import org.jetbrains.ktor.application.*
//import org.jetbrains.ktor.host.*
//import org.jetbrains.ktor.http.*
////import org.jetbrains.ktor.jetty.*
//import org.jetbrains.ktor.logging.*
//import org.jetbrains.ktor.netty.Netty
//import org.jetbrains.ktor.response.*
//import org.jetbrains.ktor.routing.*

import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.routing.*

//class JsonResponse(val data: Any)
//data class Model(val name: String)

fun Application.main() {

//    val gson = GsonBuilder().create()
//
//    intercept(ApplicationCallPipeline.Infrastructure) { call ->
//        if (call.request.acceptItems().any { it.value == "application/json" }) {
//            call.transform.register<JsonResponse> { value ->
//                TextContent(gson.toJson(value.data), ContentType.Application.Json)
//            }
//        }
//    }
//
//    val model = Model("root")
//
//    routing {
//        get("/v1") {
////            call.respondText("fooo")
//            call.respond(JsonResponse(model))
//        }
////        get("/v1/item/{key}") {
////            call.respond(JsonResponse(model.items.first { it.key == call.parameters["key"] }))
////        }
//    }

    install(Routing) {
        api()
    }

}

//fun Application.de.sveri.realworld.main() {
//
//    install(Routing) {
//        get("/") {
//            val response = mapOf("message" to greeting(User()))
//            call.respondText(response.toJson(), ContentType.Application.Json)
//        }
//    }
//}