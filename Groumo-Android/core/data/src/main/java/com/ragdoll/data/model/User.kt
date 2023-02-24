package com.ragdoll.data.model

import com.ragdoll.model.User
import com.ragdoll.network.model.UserResponse

fun UserResponse.asUser() = User(
    id = userId
)