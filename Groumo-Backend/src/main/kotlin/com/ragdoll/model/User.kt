package com.ragdoll.model

import org.jetbrains.exposed.sql.Table

object User: Table() {
    val id = integer("id").autoIncrement()
    val platform = varchar("platform", 8)
    val nickname = varchar("nickname", 12)
    val profileImage = varchar("profile_image", 128)
    val email = varchar("email", 64)

    override val primaryKey = PrimaryKey(email, platform)
}
