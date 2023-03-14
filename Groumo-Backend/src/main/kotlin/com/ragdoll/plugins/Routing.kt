package com.ragdoll.plugins

import com.ragdoll.dao.DAOFacade
import com.ragdoll.route.groupUserRoute
import com.ragdoll.route.groupRoute
import com.ragdoll.route.userRoute
import io.ktor.client.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val dao by inject<DAOFacade>()
    val client by inject<HttpClient>()

    routing {
        userRoute(dao, client)
        groupRoute(dao)
        groupUserRoute(dao)
    }
}
