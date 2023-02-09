package com.ragdoll.data.repository

interface GroumoRepository {
    suspend fun signUp(token: String, platform: String)
}