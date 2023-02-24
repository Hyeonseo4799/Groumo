package com.ragdoll.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class User(val userId: Int, val platform: String, val nickname: String, val profileImage: String, val email: String)

object Users : Table() {
    val userId = integer("user_id").autoIncrement()
    val platform = varchar("platform", 8)
    val nickname = varchar("nickname", 12)
    val profileImage = varchar("profile_image", 128)
    val email = varchar("email", 64)

    override val primaryKey = PrimaryKey(userId)
}
