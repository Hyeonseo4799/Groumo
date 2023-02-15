package com.ragdoll.dao

import com.ragdoll.dao.DatabaseFactory.dbQuery
import com.ragdoll.model.User
import com.ragdoll.model.Users
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToUser(row: ResultRow) = User(
        id = row[Users.id],
        platform = row[Users.platform],
        nickname = row[Users.nickname],
        profileImage = row[Users.profileImage],
        email = row[Users.email]
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
}