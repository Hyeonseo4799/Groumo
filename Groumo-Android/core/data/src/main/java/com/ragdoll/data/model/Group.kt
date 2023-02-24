package com.ragdoll.data.model

import com.ragdoll.model.Group
import com.ragdoll.network.model.GroupResponse

fun GroupResponse.asGroup() = Group(
    id = groupId,
    groupName = groupName,
    description = description,
    creator = creator,
    initialFunds = initialFunds,
    endDate = endDate
)