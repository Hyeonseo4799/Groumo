package com.ragdoll.data.repository

import com.ragdoll.data.model.asGroup
import com.ragdoll.data.model.asUser
import com.ragdoll.model.Group
import com.ragdoll.network.remote.GroumoDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GroumoRepositoryImpl @Inject constructor(
    private val groumoDataSource: GroumoDataSource
) : GroumoRepository {
    override suspend fun signUp(token: String, platform: String) = flow {
        emit(groumoDataSource.signUp(token, platform).asUser())
    }

    override suspend fun getGroup(userId: Int): Flow<List<Group>> = flow {
        emit(groumoDataSource.getGroup(userId).map { it.asGroup() })
    }

    override suspend fun getAllGroups(): Flow<List<Group>> = flow {
        emit(groumoDataSource.getAllGroups().map { it.asGroup() })
    }

    override suspend fun leaveGroup(userId: Int, groupId: Int): Flow<List<Group>> = flow {
        emit(groumoDataSource.leaveGroup(userId, groupId).map { it.asGroup() })
    }

    override suspend fun attendGroup(userId: Int, groupId: Int) =
        groumoDataSource.attendGroup(userId, groupId)
}