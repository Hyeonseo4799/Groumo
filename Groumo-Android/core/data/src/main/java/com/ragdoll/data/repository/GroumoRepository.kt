package com.ragdoll.data.repository

interface GroumoRepository {
    suspend fun signUp(platform: String, token: String)
}