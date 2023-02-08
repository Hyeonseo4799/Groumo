package com.ragdoll.network.retrofit

import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface GroumoApi {
    @POST("/user")
    suspend fun signUp(
        @Header("token") token: String,
        @Query("platform") platform: String
    )
}