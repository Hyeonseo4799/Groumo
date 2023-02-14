package com.ragdoll.network.remote

import com.ragdoll.network.model.NetworkResponse

interface GroumoDataSource {
    suspend fun signUp(token: String, platform: String): NetworkResponse
}