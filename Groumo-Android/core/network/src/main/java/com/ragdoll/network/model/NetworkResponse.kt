package com.ragdoll.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse(
    val code: Int,
    val error: String? = null
)