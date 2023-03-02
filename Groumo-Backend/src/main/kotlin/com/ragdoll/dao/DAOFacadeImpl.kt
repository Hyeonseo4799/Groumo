package com.ragdoll.dao

import com.ragdoll.dao.DatabaseFactory.dbQuery
import com.ragdoll.model.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToUser(row: ResultRow) = User(
        userId = row[Users.userId],
        platform = row[Users.platform],
        nickname = row[Users.nickname],
        profileImage = row[Users.profileImage],
        email = row[Users.email]
    )

    private fun resultRowGroupUser(row: ResultRow) = GroupUser(
        userId = row[GroupUsers.userId],
        groupId = row[GroupUsers.groupId],
        funds = row[GroupUsers.funds]
    )

    private fun resultRowGroup(row: ResultRow) = Group(
        groupId = row[Groups.groupId],
        groupName = row[Groups.groupName],
        description = row[Groups.description],
        creator = row[Groups.creator],
        initialFunds = row[Groups.initialFunds],
        endDate = row[Groups.endDate].toString()
    )

    override suspend fun insertUser(platform: String, nickname: String, profileImage: String, email: String): Unit =
        dbQuery {
            Users.insert {
                it[Users.platform] = platform
                it[Users.nickname] = nickname
                it[Users.profileImage] = profileImage
                it[Users.email] = email
            }
        }

    override suspend fun getUser(platform: String, email: String): User? = dbQuery {
        Users.select { (Users.platform eq platform) and (Users.email eq email) }
            .map(::resultRowToUser)
            .singleOrNull()
    }

    override suspend fun getGroupUser(userId: Int): List<GroupUser> = dbQuery {
        GroupUsers.select { GroupUsers.userId eq userId }
            .map(::resultRowGroupUser)
    }

    override suspend fun getGroup(groupId: Int): Group = dbQuery {
        Groups.select { Groups.groupId eq groupId }
            .map(::resultRowGroup)
            .single()
    }

    override suspend fun deleteGroupUser(userId: Int, groupId: Int): List<GroupUser> = dbQuery {
        GroupUsers.deleteWhere { (GroupUsers.userId eq userId) and (GroupUsers.groupId eq groupId) }
        GroupUsers.select { GroupUsers.userId eq userId }
            .map(::resultRowGroupUser)
    }
}