package com.ragdoll.network.remote

import com.ragdoll.network.retrofit.GroumoApi
import javax.inject.Inject

class GroumoDataSourceImpl @Inject constructor(
    private val groumoApi: GroumoApi
) : GroumoDataSource {
    override suspend fun signUp(token: String, platform: String) =
        groumoApi.signUp(token, platform)
}

