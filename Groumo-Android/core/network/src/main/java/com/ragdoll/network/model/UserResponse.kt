package com.ragdoll.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: Int,
    val platform: String,
    val nickname: String,
    val profileImage: String,
    val email: String
)
