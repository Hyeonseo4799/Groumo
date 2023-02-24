package com.ragdoll.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

@Serializable
data class Group(
    val groupId: Int,
    val groupName: String,
    val description: String,
    val creator: String,
    val initialFunds: Int,
    val endDate: String
)

object Groups : Table() {
    val groupId = integer("group_id").autoIncrement()
    val groupName = varchar("group_name", 12)
    val description = varchar("description", 128)
    val creator = varchar("creator", 12)
    val initialFunds = integer("initial_funds")
    val endDate = date("end_date")

    override val primaryKey = PrimaryKey(groupId)
}