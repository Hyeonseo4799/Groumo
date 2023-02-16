package com.ragdoll.network.retrofit

import com.ragdoll.network.model.UserResponse
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface GroumoApi {
    @POST("/user/{platform}")
    suspend fun signUp(
        @Header("token") token: String,
        @Path("platform") platform: String
    ): UserResponse

}