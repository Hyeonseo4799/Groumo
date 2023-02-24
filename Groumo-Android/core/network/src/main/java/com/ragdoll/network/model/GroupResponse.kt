package com.ragdoll.network.model

import kotlinx.serialization.Serializable

@Serializable
data class GroupResponse(
    val groupId: Int,
    val groupName: String,
    val description: String,
    val creator: String,
    val initialFunds: Int,
    val endDate: String
)