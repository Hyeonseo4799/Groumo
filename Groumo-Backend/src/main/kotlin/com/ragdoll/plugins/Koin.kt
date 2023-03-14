package com.ragdoll.plugins

import com.ragdoll.di.clientModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.installKoin() {
    install(Koin) {
        modules(clientModule)
    }
}