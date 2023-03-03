package com.ragdoll.network.remote

import com.ragdoll.network.model.GroupResponse
import com.ragdoll.network.retrofit.GroumoApi
import javax.inject.Inject

class GroumoDataSourceImpl @Inject constructor(
    private val groumoApi: GroumoApi
) : GroumoDataSource {
    override suspend fun signUp(token: String, platform: String) =
        groumoApi.signUp(token, platform)

    override suspend fun getGroup(userId: Int): List<GroupResponse> =
        groumoApi.getGroup(userId)

    override suspend fun getAllGroups(): List<GroupResponse> =
        groumoApi.getAllGroups()


    override suspend fun leaveGroup(userId: Int, groupId: Int): List<GroupResponse> =
        groumoApi.leaveGroup(userId, groupId)
}

