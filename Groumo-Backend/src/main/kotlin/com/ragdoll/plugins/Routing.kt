package com.ragdoll.plugins

import com.ragdoll.dao.DAOFacade
import com.ragdoll.dao.DAOFacadeImpl
import com.ragdoll.route.deleteGroupUserRoute
import com.ragdoll.route.getGroupRoute
import com.ragdoll.route.postGroupUserRoute
import com.ragdoll.route.postUserRoute
import io.ktor.client.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val dao by inject<DAOFacade>()
    val client by inject<HttpClient>()

    routing {
        postUserRoute(dao, client)
        getGroupRoute(dao)
        deleteGroupUserRoute(dao)
        postGroupUserRoute(dao)
    }
}
