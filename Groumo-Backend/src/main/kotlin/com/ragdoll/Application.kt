package com.ragdoll

import com.ragdoll.dao.DatabaseFactory
import io.ktor.server.application.*
import com.ragdoll.plugins.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    DatabaseFactory.init(environment.config)
    configureSerialization()
    installKoin()
    configureRouting()
}
