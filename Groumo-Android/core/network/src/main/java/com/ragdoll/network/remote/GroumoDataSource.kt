package com.ragdoll.network.remote

interface GroumoDataSource {
    suspend fun signUp(platform: String, token: String)
}