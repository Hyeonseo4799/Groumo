package com.ragdoll.model

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val code: Int,
    val error: String? = null
)
