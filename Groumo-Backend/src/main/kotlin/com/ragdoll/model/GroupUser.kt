package com.ragdoll.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class GroupUser(val userId: Int, val groupId: Int, val funds: Int)

object GroupUsers: Table() {
    val userId = integer("user_id").references(Users.userId)
    val groupId = integer("group_id").references(Groups.groupId)
    val funds = integer("funds")

    override val primaryKey = PrimaryKey(userId, groupId)
}