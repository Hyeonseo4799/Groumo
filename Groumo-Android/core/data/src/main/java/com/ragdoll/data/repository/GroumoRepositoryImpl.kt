package com.ragdoll.data.repository

import com.ragdoll.network.remote.GroumoDataSource
import javax.inject.Inject

class GroumoRepositoryImpl @Inject constructor(
    private val groumoDataSource: GroumoDataSource
): GroumoRepository {
    override suspend fun signUp(token: String, platform: String) {
        groumoDataSource.signUp(token, platform)
    }
}