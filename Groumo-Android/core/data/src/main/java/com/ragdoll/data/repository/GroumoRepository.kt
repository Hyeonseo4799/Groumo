package com.ragdoll.data.repository

import com.ragdoll.model.Group
import com.ragdoll.model.User
import kotlinx.coroutines.flow.Flow

interface GroumoRepository {
    suspend fun signUp(token: String, platform: String): Flow<User>

    suspend fun getGroup(userId: Int): Flow<List<Group>>
}