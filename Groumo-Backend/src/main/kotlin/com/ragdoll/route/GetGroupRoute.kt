package com.ragdoll.route

import com.ragdoll.dao.DAOFacade
import com.ragdoll.model.Group
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getGroupRoute(dao: DAOFacade) {
    get("group") {
        val userId = call.request.queryParameters["userId"]?.toIntOrNull()

        if (userId == null) {
            call.respond(HttpStatusCode.OK, dao.getAllGroups())
        } else {
            val groupUser = dao.getGroupUser(userId)
            val group = mutableListOf<Group>()

            groupUser.forEach { group.add(dao.getGroup(it.groupId)) }
            call.respond(HttpStatusCode.OK, group)
        }
    }
}