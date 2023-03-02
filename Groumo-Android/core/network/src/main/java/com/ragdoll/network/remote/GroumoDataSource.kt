package com.ragdoll.network.remote

import com.ragdoll.network.model.GroupResponse
import com.ragdoll.network.model.UserResponse

interface GroumoDataSource {
    suspend fun signUp(token: String, platform: String): UserResponse

    suspend fun getGroup(userId: Int): List<GroupResponse>

    suspend fun leaveGroup(userId: Int, groupId: Int): List<GroupResponse>
}