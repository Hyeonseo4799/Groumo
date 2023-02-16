package com.ragdoll.network.remote

import com.ragdoll.network.model.UserResponse

interface GroumoDataSource {
    suspend fun signUp(token: String, platform: String): UserResponse
}