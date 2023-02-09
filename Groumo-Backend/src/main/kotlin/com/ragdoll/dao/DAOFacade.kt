package com.ragdoll.dao

interface DAOFacade {
    suspend fun insertUser(
        platform: String,
        nickname: String,
        profileImage: String,
        email: String
    )
}