package com.ragdoll.network.remote

interface GroumoDataSource {
    suspend fun signUp(token: String, platform: String)
}