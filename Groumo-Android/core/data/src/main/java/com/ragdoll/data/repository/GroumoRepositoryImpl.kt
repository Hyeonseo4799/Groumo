package com.ragdoll.data.repository

import com.ragdoll.data.model.asUser
import com.ragdoll.network.remote.GroumoDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GroumoRepositoryImpl @Inject constructor(
    private val groumoDataSource: GroumoDataSource
) : GroumoRepository {
    override suspend fun signUp(token: String, platform: String) = flow {
        emit(groumoDataSource.signUp(token, platform).asUser())
    }
}