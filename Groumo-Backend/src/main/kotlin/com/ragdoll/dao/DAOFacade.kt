package com.ragdoll.dao

import com.ragdoll.model.User

interface DAOFacade {
    suspend fun insertUser(platform: String, nickname: String, profileImage: String, email: String)

    suspend fun getUser(platform: String, email: String): User?
}