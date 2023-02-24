package com.ragdoll.network.retrofit

import com.ragdoll.network.model.GroupResponse
import com.ragdoll.network.model.UserResponse
import retrofit2.http.*

interface GroumoApi {
    @POST("/user/{platform}")
    suspend fun signUp(
        @Header("token") token: String,
        @Path("platform") platform: String
    ): UserResponse

    @GET("/group")
    suspend fun getGroup(
        @Query("userId") userId: Int
    ): List<GroupResponse>
}