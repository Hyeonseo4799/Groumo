package com.ragdoll.dao

import com.ragdoll.dao.DatabaseFactory.dbQuery
import com.ragdoll.model.User
import org.jetbrains.exposed.sql.insert

class DAOFacadeImpl : DAOFacade {
    override suspend fun insertUser(
        platform: String,
        nickname: String,
        profileImage: String,
        email: String
    ): Unit = dbQuery {
        User.insert {
            it[User.platform] = platform
            it[User.nickname] = nickname
            it[User.profileImage] = profileImage
            it[User.email] = email
        }
    }
}