package com.ragdoll

import com.ragdoll.dao.DatabaseFactory
import io.ktor.server.application.*
import com.ragdoll.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    DatabaseFactory.init(environment.config)
    configureSerialization()
    configureRouting()
}
