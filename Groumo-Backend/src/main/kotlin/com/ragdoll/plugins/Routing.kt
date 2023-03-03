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

fun Application.configureRouting(client: HttpClient) {
    val dao: DAOFacade = DAOFacadeImpl()
    routing {
        postUserRoute(dao, client)
        getGroupRoute(dao)
        deleteGroupUserRoute(dao)
        postGroupUserRoute(dao)
    }
}
