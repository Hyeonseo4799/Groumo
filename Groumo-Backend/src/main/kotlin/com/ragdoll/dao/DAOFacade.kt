package com.ragdoll.dao

import com.ragdoll.model.Group
import com.ragdoll.model.GroupUser
import com.ragdoll.model.User

interface DAOFacade {
    suspend fun insertUser(platform: String, nickname: String, profileImage: String, email: String)

    suspend fun getUser(platform: String, email: String): User?

    suspend fun getGroupUser(userId: Int): List<GroupUser>

    suspend fun getGroup(groupId: Int): Group

    suspend fun deleteGroupUser(userId: Int, groupId: Int): List<GroupUser>
}