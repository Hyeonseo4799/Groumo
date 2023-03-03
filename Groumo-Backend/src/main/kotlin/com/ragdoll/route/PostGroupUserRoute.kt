package com.ragdoll.route

import com.ragdoll.dao.DAOFacade
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.postGroupUserRoute(dao: DAOFacade) {
    post("group/user") {
        val userId = call.request.queryParameters["userId"]!!.toInt()
        val groupId = call.request.queryParameters["groupId"]!!.toInt()

        val funds = dao.getGroup(groupId).initialFunds

        dao.insertGroupUserRoute(userId, groupId, funds)

        call.respond(HttpStatusCode.OK)
    }
}