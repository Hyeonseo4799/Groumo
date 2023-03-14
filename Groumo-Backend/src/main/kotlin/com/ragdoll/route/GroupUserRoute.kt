package com.ragdoll.route

import com.ragdoll.dao.DAOFacade
import com.ragdoll.model.Group
import com.ragdoll.model.GroupUser
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.groupUserRoute(dao: DAOFacade) {
    post("group/user") {
        val userId = call.request.queryParameters["userId"]!!.toInt()
        val groupId = call.request.queryParameters["groupId"]!!.toInt()

        val funds = dao.getGroup(groupId).initialFunds

        dao.insertGroupUserRoute(userId, groupId, funds)

        call.respond(HttpStatusCode.OK)
    }

    delete("group/user") {
        val userId = call.request.queryParameters["userId"]?.toIntOrNull()
        val groupId = call.request.queryParameters["groupId"]?.toIntOrNull()

        if (userId == null || groupId == null) {
            call.respond(HttpStatusCode.OK, emptyList<GroupUser>())
        } else {
            val groupUser = dao.deleteGroupUser(userId, groupId)
            val group = mutableListOf<Group>()

            groupUser.forEach { group.add(dao.getGroup(it.groupId)) }
            call.respond(HttpStatusCode.OK, group)
        }
    }
}